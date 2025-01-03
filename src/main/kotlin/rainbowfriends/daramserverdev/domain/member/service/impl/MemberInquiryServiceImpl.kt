package rainbowfriends.daramserverdev.domain.member.service.impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.member.component.FindAllMember
import rainbowfriends.daramserverdev.domain.member.dto.response.GetMemberResponse
import rainbowfriends.daramserverdev.domain.member.exception.MemberNotFoundException
import rainbowfriends.daramserverdev.domain.member.service.MemberInquiryService

@Service
class MemberInquiryServiceImpl(
    private val findAllMember: FindAllMember
) : MemberInquiryService {

    override fun getAllMember(
        id: Long?,
        stay: Boolean?,
        floor: Int?,
        room: Int?,
        grade: Int?,
        classNum: Int?
    ): List<GetMemberResponse> {
        val allMembers = findAllMember.findMemberByCache().map {
            GetMemberResponse(
                id = it.id,
                stay = it.stay,
                floor = it.floor,
                room = it.room,
                grade = it.grade,
                classNum = it.classNum,
                name = it.name,
                role = it.role,
                lateNumber = it.lateNumber,
                number = it.number
            )
        }
        val filteredMembers = allMembers.filter {
            (id == null || it.id == id) &&
                    (stay == null || it.stay == stay) &&
                    (floor == null || it.floor == floor) &&
                    (room == null || it.room == room) &&
                    (grade == null || it.grade == grade) &&
                    (classNum == null || it.classNum == classNum)
        }
        if (filteredMembers.isEmpty()) {
            throw MemberNotFoundException("No member found")
        }
        return filteredMembers.map {
            GetMemberResponse(
                id = it.id,
                stay = it.stay,
                floor = it.floor,
                room = it.room,
                grade = it.grade,
                classNum = it.classNum,
                name = it.name,
                role = it.role,
                lateNumber = it.lateNumber,
                number = it.number
            )
        }
    }
}