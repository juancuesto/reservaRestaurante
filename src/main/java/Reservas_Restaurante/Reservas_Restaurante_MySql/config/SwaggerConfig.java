package Reservas_Restaurante.Reservas_Restaurante_MySql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuracion Swagger para la generacion de la documentación de la API REST
 * http://localhost:8080/swagger-ui/
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.baeldung.web.controller"))
                .paths(PathSelectors.ant("/clientes/* , /mesas/*"))
                .build();
    }
}
