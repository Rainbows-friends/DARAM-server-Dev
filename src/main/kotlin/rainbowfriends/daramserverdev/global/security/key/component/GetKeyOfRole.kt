package rainbowfriends.daramserverdev.global.security.key.component

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import rainbowfriends.daramserverdev.global.member.enums.Roles
import rainbowfriends.daramserverdev.global.security.key.repository.KeyRepository

@Deprecated(message = "Use JwtTokenParserService instead")
@Component
@Transactional
class GetKeyOfRole(private val keyRepository: KeyRepository) {
    fun getKeyOfRole(key: String):Roles {
        return keyRepository.findByKey(key).role
    }
}