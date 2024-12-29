package rainbowfriends.daramserverdev.global.member.entity

import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import rainbowfriends.daramserverdev.domain.member.exception.InvalidStudentIdException
import rainbowfriends.daramserverdev.global.member.dto.MemberDTO
import rainbowfriends.daramserverdev.global.member.enums.Roles

@Entity
@Table(name = "members_table")
@SecondaryTable(
    name = "member_late_table",
    pkJoinColumns = [PrimaryKeyJoinColumn(name = "member_id", referencedColumnName = "id")]
)
@BatchSize(size = 50)  // 한 번에 가져올 데이터의 양을 설정
data class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    @Column(nullable = true, unique = true)
    var email: String? = null,
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
    val role: Roles,
    @Column(nullable = false)
    val stay: Boolean = true,
    @Column(name = "late", table = "member_late_table", nullable = false)
    var lateNumber: Long? = 0
) {
    fun generateStudentId(grade: Int, classNum: Int, number: Int): Short {
        if (grade < 1 || grade > 3) {
            throw InvalidStudentIdException("Invalid grade: $grade")
        }
        if (classNum < 1 || classNum > 4) {
            throw InvalidStudentIdException("Invalid classNum: $classNum")
        }
        if (number < 1 || number > 19) {
            throw InvalidStudentIdException("Invalid number: $number")
        }
        return String.format("%d%d%02d", grade, classNum, number).toShort()
    }

    fun toDto(): MemberDTO {
        return MemberDTO(
            id = id!!,
            email = this.email,
            name = this.name,
            grade = this.grade,
            classNum = this.classNum,
            number = this.number,
            floor = this.floor,
            room = this.room,
            role = this.role,
            stay = this.stay,
            lateNumber = this.lateNumber!!
        )
    }
}