package annotatedspring;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;

import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
public class StepDefinitions  extends FluentTest {
    private WebDriver driver;

    @Value("${local.server.port}")
    protected int port;

    private String baseUrl;

    @Before
    public void before() {
        setupFluentlenium();
    }

    @After
    public void after(){
        teardownFluentlenium();
    }

    @Override
    public WebDriver getDefaultDriver() {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            driver = new PhantomJSDriver(capabilities);
        }

        return driver;
    }

    @When("^I visit the homepage$")
    public void I_visit_the_homepage() throws Throwable {
        goTo(baseUrl);
    }

    @Then("^I should see the site title$")
    public void I_should_see_the_site_title() throws Throwable {
        assertThat(findFirst("h1").getText(), containsString("Annotated Spring"));
    }

    protected void setupFluentlenium() {
        try {
            baseUrl = new URI("http://localhost:" + port + "/").normalize().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        this.initFluent(getDefaultDriver());
        this.initTest();
    }

    protected void teardownFluentlenium() {
        this.quit();
    }
}
