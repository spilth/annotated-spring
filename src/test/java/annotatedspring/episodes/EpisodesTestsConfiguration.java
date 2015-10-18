package annotatedspring.episodes;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class EpisodesTestsConfiguration {

    @Bean
    public PropertyPlaceholderConfigurer propConfig() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("application-test.properties"));
        return ppc;
    }
}
