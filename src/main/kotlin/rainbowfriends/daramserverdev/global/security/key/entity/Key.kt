package rainbowfriends.daramserverdev.global.security.key.entity

import jakarta.persistence.*
import rainbowfriends.daramserverdev.global.member.enums.Roles

@Deprecated(message = "This class is deprecated")
@Entity
@Table(name = "key_table")
data class Key(
    @Id @Column(name = "`key`", unique = true)
    val key: String,
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    val role: Roles
)