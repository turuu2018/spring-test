package mn.turuu.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author PDBD
 */
@Configuration
@ComponentScan(basePackages = {"mn.turuu.springtest"})
@Import({WebMvcConfig.class, DatabaseConfig.class, SecurityConfig.class})
public class RootConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
