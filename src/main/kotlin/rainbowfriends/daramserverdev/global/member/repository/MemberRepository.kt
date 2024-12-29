package rainbowfriends.daramserverdev.global.member.repository

import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import rainbowfriends.daramserverdev.global.member.entity.Member

@Repository
interface MemberRepository : JpaRepository<Member, Long?> {
    @Cacheable(value = ["MemberByStudentId"], key = "T(String).format('%d%d%02d', #grade, #classNum, #number)")
    @Query("SELECT m FROM Member m WHERE m.grade = :grade AND m.classNum = :classNum AND m.number = :number")
    fun findByGradeAndClassNumAndNumber(grade: Int, classNum: Int, number: Int): Member?
    @Cacheable(value = ["MemberByEmail"], key = "#email")
    fun findByEmail(email: String?): Member?
}