package rainbowfriends.daramserverv2.global.member.entity

import jakarta.persistence.*
import rainbowfriends.daramserverv2.global.member.enums.Roles

@Entity
@Table(name = "members")
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    @Column(nullable = false)
    val name: String,
    @Column(nullable = false)
    val grade: Int,
    @Column(nullable = false, name = "class")
    val classNum: Int,
    @Column(nullable = false)
    val number: Int,
    @Column(nullable = false)
    val floor: Int,
    @Column(nullable = false)
    val room: Int,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val role: Roles
)