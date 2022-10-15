package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.config.swagger

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.config.property.SecurityConfigurationProperty
import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.Scopes
import io.swagger.v3.oas.models.security.SecurityRequirement
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author Nicholas Dietz
 *
 * Swagger configuration @see http://<host>:[application.yml:server.port]/swagger-ui.html#
 * Keep in mind that you have to authorize yourself to access any endpoint!
 **/
@Configuration
class SwaggerConfig(
    val securityConfigurationProperty: SecurityConfigurationProperty,
    val buildProperties: BuildProperties
) {

    @Bean
    fun appOpenApiConfiguration(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .version(buildProperties.version)
                    .title("REPLACE_APP_NAME REST-API")
                    .contact(
                        Contact()
                            .name("FN LN")
                            .email("FN.LN@REPLACE_GROUP.REPLACE_DOMAIN")
                    )
                    .termsOfService("<terms and conditions>")
                    .license(License().name("<licence>"))
                    .description("<application description>")
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("<doc type>")
                    .url("<url-to-doc>"),
            )
            .security(
                listOf(
                    SecurityRequirement().addList("OAuth2 Authorization Client-Credentials"),
                    SecurityRequirement().addList("OAuth2 Authorization Implicit")
                )
            )
            .schemaRequirement(
                "OAuth2 Authorization Implicit",
                io.swagger.v3.oas.models.security.SecurityScheme()
                    .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.OAUTH2)
                    .flows(
                        io.swagger.v3.oas.models.security.OAuthFlows()
                            .implicit(
                                io.swagger.v3.oas.models.security.OAuthFlow()
                                    .authorizationUrl("${securityConfigurationProperty.externalAuthServerUrl}/realms/${securityConfigurationProperty.realm}/protocol/openid-connect/auth")
                                    .tokenUrl("${securityConfigurationProperty.externalAuthServerUrl}/realms/${securityConfigurationProperty.realm}/protocol/openid-connect/token")
                                    .refreshUrl("${securityConfigurationProperty.externalAuthServerUrl}/realms/${securityConfigurationProperty.realm}/protocol/openid-connect/auth")
                                    .scopes(Scopes())
                            )
                    )
            )
            .schemaRequirement(
                "OAuth2 Authorization Client-Credentials",
                io.swagger.v3.oas.models.security.SecurityScheme()
                    .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.OAUTH2)
                    .flows(
                        io.swagger.v3.oas.models.security.OAuthFlows()
                            .clientCredentials(
                                io.swagger.v3.oas.models.security.OAuthFlow()
                                    .authorizationUrl("${securityConfigurationProperty.externalAuthServerUrl}/realms/${securityConfigurationProperty.realm}/protocol/openid-connect/auth")
                                    .tokenUrl("${securityConfigurationProperty.externalAuthServerUrl}/realms/${securityConfigurationProperty.realm}/protocol/openid-connect/token")
                                    .scopes(Scopes())
                            )
                    )
            )
    }
}