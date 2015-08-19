package annotatedspring;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber"},
    glue = {"annotatedspring", "cucumber.api.spring"}
)
public class FeatureTests {

}
