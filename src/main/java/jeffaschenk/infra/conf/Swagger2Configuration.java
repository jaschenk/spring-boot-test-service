package jeffaschenk.infra.conf;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Enable Swagger 
 */
@EnableSwagger2
public class Swagger2Configuration {


    /**
     * Swagger2 Docket Configuration
     * @return Docket Bean Reference
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("jeffaschenk.infra.controller"))
                //.paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/apiError"))) // Exclude Spring error controllers
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("Test Service API Documentation",
                "REST API Documentation for Employer Portal and Dashboard Services",
                "1.0.0",
                "urn:tos",
                new Contact("Jeff Schenk", "", ""),
                "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }

}
