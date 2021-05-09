package restAssured;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class gmiBankStepDefs {

    RequestSpecification request;
    Response response;

    @Given("enter the baseUri {string}")
    public void enter_the_base_uri(String baseUri) {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZWFtNW1hbmFnZXIiLCJhdXRo" +
                "IjoiUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjE2NDQwNzYzfQ.NcqMfaickAw2-e2HwB" +
                "jnqOCZjVkE8fdkjQCLB51Wrsw5ijXj3bzWRzAyfdS_EkJEr_h2aHOjYMMWPf6LVWcWbA";

        request = given()
                .auth().oauth2(token)
                .contentType("application/json")
                .accept("application/json")
                .baseUri(baseUri);
    }

    @And("enter the basePath {string}")
    public void enter_the_base_path(String basePath) {
        request
                .log()
                .all()
                .basePath(basePath);

    }

    @When("get the customers")
    public void get_the_customers() {

        response = request
                .when()
                .get();
    }

    @Then("assert the status code {int}")
    public void assert_the_status_code(Integer expectedStatusCode) {
        response
                .then()
                .assertThat()
                .statusCode(expectedStatusCode);

        response.prettyPrint();
    }

}
