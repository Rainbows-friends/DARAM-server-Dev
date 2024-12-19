package rainbowfriends.daramserverdev.domain.auth.service

import rainbowfriends.daramserverdev.domain.auth.dto.response.SigninOrReissueResponse

interface SignInService {
    fun signIn(code: String): SigninOrReissueResponse
}