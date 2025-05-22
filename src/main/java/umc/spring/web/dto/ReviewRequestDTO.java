package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewDTO{
        @NotBlank
        String body;
        @NotNull
        Float score;
        @NotBlank
        String memberName;
        @NotBlank
        String storeName;
    }
}
