package tn.esprit.autoloc.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "AutoLoc API",
                version = "1.0",
                description = "API de gestion d'une agence de location de véhicules.",
                contact = @Contact(name = "AutoLoc")
        )
)
public class OpenApiConfig {
}
