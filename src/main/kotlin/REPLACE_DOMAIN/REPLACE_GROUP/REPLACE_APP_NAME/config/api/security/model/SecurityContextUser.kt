package REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.config.api.security.model

import REPLACE_DOMAIN.REPLACE_GROUP.REPLACE_APP_NAME.utils.*
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt

class SecurityContextUser(
    authorities: MutableCollection<out GrantedAuthority> = mutableListOf(),
    private val token: Jwt
) : AbstractAuthenticationToken(authorities) {

    override fun getCredentials(): Any? {
        return null
    }

    override fun isAuthenticated(): Boolean {
        return true
    }

    override fun getPrincipal(): Any {
        return SecurityContextUserPrincipal(
            id = token.getUserId(),
            username = token.getUsername(),
            email = token.getEmail(),
            firstname = token.getFirstName(),
            lastname = token.getLastName(),
            fullName = token.getFullName(),
            locale = token.getLocale(),
            token
        )
    }


}