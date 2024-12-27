package rainbowfriends.daramserverdev.domain.auth.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import rainbowfriends.daramserverdev.domain.auth.dto.AuthorizeAdminRequest
import rainbowfriends.daramserverdev.domain.auth.dto.request.CameraAuthorizationRequest
import rainbowfriends.daramserverdev.domain.auth.dto.request.ReissueRequest
import rainbowfriends.daramserverdev.domain.auth.dto.request.SignInRequest
import rainbowfriends.daramserverdev.domain.auth.dto.response.SigninOrReissueResponse
import rainbowfriends.daramserverdev.domain.auth.service.*
import rainbowfriends.daramserverdev.global.security.dto.TokenResponse

@RequestMapping("/auth")
@RestController
class AuthController(
    private val adminAuthorizationService: AdminAuthorizationService,
    private val logoutService: LogoutService,
    private val signInService: SignInService,
    private val cameraAuthorizationService: CameraAuthorizationService,
    private val reissueService: ReissueService,
    private val validateTokenService: ValidateTokenService
) {
    @PostMapping
    @Deprecated(message = "Google OAuth2 Authorization use")
    fun authorizeAdmin(@RequestBody key: AuthorizeAdminRequest): TokenResponse {
        return adminAuthorizationService.authorizeAdmin(key.key)
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Deprecated(message = "Google OAuth2 Authorization use")
    fun logout(request: HttpServletRequest) {
        logoutService.logout(request)
    }

    @PostMapping("/signin")
    fun signIn(@RequestBody code: SignInRequest): SigninOrReissueResponse {
        return signInService.signIn(code.code)
    }

    @PostMapping("/camera/authorization")
    fun cameraAuthorization(@RequestBody key: CameraAuthorizationRequest): SigninOrReissueResponse {
        return cameraAuthorizationService.cameraAuthorization(key.key)
    }

    @PutMapping("/refresh")
    fun reissue(@RequestBody refreshToken: ReissueRequest): SigninOrReissueResponse {
        return reissueService.reissue(refreshToken.refreshToken)
    }

    @GetMapping("/token/validate")
    fun validateToken(@RequestHeader("Authorization") authorization: String): Boolean {
        return validateTokenService.validateToken(authorization.removePrefix("Bearer ").trim())
    }
}