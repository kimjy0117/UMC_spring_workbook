package umc.spring.service.MissionService;

import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionService {
    void saveMission(MissionRequestDTO.MissionJoinDTO missionJoinDTO);
    void saveMemberMission(MemberMissionRequestDTO.MemberMissionDTO memberMissionDTO);
}
