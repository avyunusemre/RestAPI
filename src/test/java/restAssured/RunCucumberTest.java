package restAssured;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/petStore.feature"},
        plugin = {"pretty",
                //"summary",
                "html:target/cucumber.html",
                "de.monochromata.cucumber.report.PrettyReports:result/cucumber"
        },
        tags = "@petTest"
)
public class RunCucumberTest {
}
