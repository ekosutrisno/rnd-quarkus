package org.ekosutrisno.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {@Tag(name = "RnD Quarkus Development", description = "First API Using Quarkus")},
        info = @Info(
                title = "Product Service API",
                version = "v0.0.1",
                contact = @Contact(
                        name = "Eko Sutrisno",
                        url = "https://www.apache.org/licenses/LICENSE-2.0",
                        email = "ekosutrisno801@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0" )
        )
)
public class OpenApiConfig extends Application {
}
