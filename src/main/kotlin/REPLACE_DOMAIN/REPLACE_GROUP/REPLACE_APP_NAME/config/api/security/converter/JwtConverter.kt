package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.config.api.security.converter

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.config.api.security.model.SecurityContextUser
import org.springframework.core.convert.converter.Converter
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter



class JwtConverter: Converter<Jwt, SecurityContextUser> {

    override fun convert(source: Jwt): SecurityContextUser {
        return SecurityContextUser(
            JwtAuthenticationConverter().convert(source)!!.authorities.orEmpty().toMutableList(),
            source
        )
    }
}