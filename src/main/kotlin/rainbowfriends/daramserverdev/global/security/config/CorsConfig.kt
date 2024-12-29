package rainbowfriends.daramserverdev.global.security.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Component
class CorsConfig(
    @Value("\${production.url}")
    val productionUrl: String,
    @Value("\${production.front-url}")
    val productionFrontUrl: String
) {
    @Bean
    fun configureCors(): UrlBasedCorsConfigurationSource {
        val config = CorsConfiguration().apply {
            allowCredentials = true
            allowedOrigins = listOf("*")
            allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
            allowedHeaders = listOf("*")
        }
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", config)
        return source
    }
}