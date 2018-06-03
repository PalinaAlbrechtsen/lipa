package bye.kosha.dao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfiguration.class)
@ComponentScan(basePackages = "bye.kosha.util")
public class TestConfiguration {
}
