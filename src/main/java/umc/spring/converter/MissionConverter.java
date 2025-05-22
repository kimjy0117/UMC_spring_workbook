package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MissionRequestDTO;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.MissionJoinDTO missionJoinDTO, Store store){
        return Mission.builder()
                .reward(missionJoinDTO.getReward())
                .deadline(missionJoinDTO.getDeadline())
                .missionSpec(missionJoinDTO.getMissionSpec())
                .store(store)
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.MemberMissionDTO memberMissionDTO, Member member, Mission mission){
        MissionStatus missionStatus = null;

        switch (memberMissionDTO.getStatus()){
            case 1:
                missionStatus = MissionStatus.CHALLENGING;
                break;
            case 2:
                missionStatus = MissionStatus.COMPLETE;
                break;
        }

        return MemberMission.builder()
                .status(missionStatus)
                .member(member)
                .mission(mission)
                .build();
    }
}
