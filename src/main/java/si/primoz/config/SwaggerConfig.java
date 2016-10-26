package si.primoz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;

/**
 *
 * @author pmarijan
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
            .groupName("news-api")
            .select()
            .apis(RequestHandlerSelectors.any()) 
            .paths(PathSelectors.ant("/api/*"))
            .build()
            .apiInfo(apiInfo());                                           
    }
    
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("News API", 
                "Api reading and managing news items.", 
                null, 
                null, 
                "Primož Marijan", 
                null, 
                null);
    return apiInfo;
}
}
