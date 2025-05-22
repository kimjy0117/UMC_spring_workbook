package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDTO {
    @Getter
    public static class MemberMissionDTO{
        @NotNull
        int status;
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
    }
}
