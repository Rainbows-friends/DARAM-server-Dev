package rainbowfriends.daramserverdev.domain.member.component

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.domain.member.exception.MemberNotFoundException
import rainbowfriends.daramserverdev.global.member.entity.Member
import rainbowfriends.daramserverdev.global.member.repository.MemberRepository

@Component
class FindAllMember(private val memberRepository: MemberRepository) {
    @Cacheable(value = ["allMembers"], key = "'allMembers'")
    fun findMemberByCache(): List<Member> {
        if (memberRepository.count() <= 0) {
            throw MemberNotFoundException("Member Not Found")
        }
        return memberRepository.findAll().toList()
    }
}