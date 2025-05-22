package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class MissionJoinDTO {
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotBlank
        String missionSpec;
        @NotBlank
        String storeName;
    }
}
