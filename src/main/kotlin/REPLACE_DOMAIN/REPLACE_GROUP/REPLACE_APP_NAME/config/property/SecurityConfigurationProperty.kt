package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.config.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConfigurationProperties("security")
@ConstructorBinding
data class SecurityConfigurationProperty(
    val internalAuthServerUrl: String,
    val externalAuthServerUrl: String,
    val clientId: String = "REPLACE_GROUP_REPLACE_APP_NAME",
    val realm: String = "REPLACE_GROUP",
    val issuers: List<String> = emptyList()
)