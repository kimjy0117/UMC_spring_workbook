package umc.spring.web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MissionService.MissionService;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MissionRequestDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionService missionService;

    //미션 추가 api
    @PostMapping("/")
    public ApiResponse<Null> addMission(@RequestBody @Valid MissionRequestDTO.MissionJoinDTO request){
        missionService.saveMission(request);
        return ApiResponse.onSuccess(null);
    }

    //미션을 도전중인 미션에 추가
    @PostMapping("/challenge")
    public ApiResponse<Null> addChallengeMission(@RequestBody @Valid MemberMissionRequestDTO.MemberMissionDTO request){
        missionService.saveMemberMission(request);
        return ApiResponse.onSuccess(null);
    }

}
