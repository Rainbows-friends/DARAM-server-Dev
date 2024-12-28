package rainbowfriends.daramserverdev.domain.member.service.impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.member.dto.request.PatchRoomRequest
import rainbowfriends.daramserverdev.domain.member.exception.MemberNotFoundException
import rainbowfriends.daramserverdev.domain.member.exception.PatchRoomException
import rainbowfriends.daramserverdev.domain.member.service.PatchRoomService
import rainbowfriends.daramserverdev.global.member.component.FindMember
import rainbowfriends.daramserverdev.global.member.component.SaveMember
import rainbowfriends.daramserverdev.global.util.ParseStudentId.parseStudentId

@Service
class PatchRoomServiceImpl(
    private val findMember: FindMember,
    private val saveMember: SaveMember
) : PatchRoomService {
    override fun patchRoom(request: PatchRoomRequest) {
        try {
            val (grade, classNum, number) = parseStudentId(request.studentId.toString())
            val member = findMember.findMemberByGradeAndClassNumAndNumber(grade, classNum, number)
                ?: throw MemberNotFoundException("Member not found for studentId: ${request.studentId}")
            val updatedDto = member.toDto().copy(
                floor = request.room / 100,
                room = request.room.toInt()
            )
            saveMember.saveMember(updatedDto.toEntity())
        } catch (e: IllegalArgumentException) {
            throw PatchRoomException("Invalid student ID format: ${request.studentId}$e")
        } catch (e: MemberNotFoundException) {
            throw PatchRoomException("Member not found for studentId: ${request.studentId}$e")
        } catch (e: Exception) {
            throw PatchRoomException("Unexpected error occurred while patching room$e")
        }
    }
}