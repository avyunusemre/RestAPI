package restAssured;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class petStoreStepDefinitions {

    RequestSpecification request;
    Response response;

    @Given("the baseUri is {string}")
    public void theBaseUriIs(String baseUri) {
      request = given()
                .contentType("application/json")
                .accept("application/json")
                .baseUri(baseUri);

    }


    @And("basePath is {string}")
    public void basepathIs(String basePath) {

        request
                .log()
                .all()
                .basePath(basePath);


    }

    @When("user creates adds a new pet")
    public void userCreatesAddsANewPet(String body) {

        response = request
                .body(body)
                .log()
                .all()
                .when()
                .post();

    }

    @Then("status code must be {int}")
    public void statusCodeMustBe(int expectedStatusCode) {

        response
                .then()
                .assertThat()
                .statusCode(expectedStatusCode);

    }

    @And("new pet's name must be {string}")
    public void newPetSNameMustBe(String expectedName) {

        response
                .then()
                .body("name",equalTo(expectedName));
    }


    @And("tags name must be {string}")
    public void tagsNameMustBe(String expectedTagName) {
        response
                .then()
                .body("tags[0].name", equalTo(expectedTagName));
    }

    @When("user updates an existing pet")
    public void userUpdatesAnExistingPet(String updateBody) {

        response = request
                    .body(updateBody)
                    .when()
                    .put();

    }

    @And("dog's new status must be {string}")
    public void dogSNewStatusMustBe(String expectedStatus) {

        response
                .then()
                .body("status", equalTo(expectedStatus));
    }

    @And("dog's ID is {int}")
    public void dogSIDIs(int petId) {
        request
                .pathParam("petId",petId);
    }

    @When("I delete the dog")
    public void iDeleteTheDog() {

        response = request
                    .when()
                    .delete();
    }

    @Given("the pet's id is {int}")
    public void thePetSIdIs(int petId) {

        request = given()
                .contentType("application/json")
                .accept("application/json")
                .pathParam("petId",petId);

    }

    @When("I get the pet by Id")
    public void iGetThePetById() {

        response = request
                    .when()
                    .get("https://petstore.swagger.io/v2/pet/{petId}");
    }

    @And("message must be {string}")
    public void messageMustBe(String message) {

        response
                .then()
                .body("message", equalTo(message));
    }
}
