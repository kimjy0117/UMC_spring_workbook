package umc.spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.apiPayload.status.ErrorStatus;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;
    private final StoreRepository  storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    //미션 추가
    @Transactional
    @Override
    public void saveMission(MissionRequestDTO.MissionJoinDTO missionJoinDTO) {
        Store store = storeRepository.findByName(missionJoinDTO.getStoreName());
        Mission mission = MissionConverter.toMission(missionJoinDTO, store);
        missionRepository.save(mission);
    }

    //도전 미션 추가
    @Transactional
    @Override
    public void saveMemberMission(MemberMissionRequestDTO.MemberMissionDTO memberMissionDTO){
        Member member = memberRepository.findById(memberMissionDTO.getMemberId())
                .orElseThrow(()-> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(memberMissionDTO.getMissionId())
                .orElseThrow(()-> new GeneralException(ErrorStatus.MISSION_NOT_EXIST));
        MemberMission memberMission = MissionConverter.toMemberMission(memberMissionDTO, member, mission);
        memberMissionRepository.save(memberMission);
    }
}
