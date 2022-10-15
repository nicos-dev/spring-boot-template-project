package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.config.mapping

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.openapitools.jackson.nullable.JsonNullableModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObjectMappingConfiguration {

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
            .registerModule(JsonNullableModule())
            .registerModule(
                KotlinModule(nullIsSameAsDefault = true)
            )
    }

}