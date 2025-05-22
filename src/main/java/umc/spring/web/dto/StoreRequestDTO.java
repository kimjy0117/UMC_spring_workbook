package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class StoreRequestDTO {
    @Getter
    public static class JoinStoreDTO{
        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotBlank
        String region;
    }
}
