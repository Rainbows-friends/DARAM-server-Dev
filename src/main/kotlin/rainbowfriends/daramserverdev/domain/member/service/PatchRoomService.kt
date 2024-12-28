package rainbowfriends.daramserverdev.domain.member.service

import rainbowfriends.daramserverdev.domain.member.dto.request.PatchRoomRequest

interface PatchRoomService {
    fun patchRoom(request: PatchRoomRequest)
}