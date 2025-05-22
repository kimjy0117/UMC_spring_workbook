package umc.spring.web.controller;

import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Region;
import umc.spring.repository.RegionRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionRestController {
    private final RegionRepository regionRepository;

    @PostMapping("/")
    public ApiResponse<Null> addRegion(@RequestBody String name){
        Region region = Region.builder().name(name).build();
        regionRepository.save(region);
        return ApiResponse.onSuccess(null);
    }
}
