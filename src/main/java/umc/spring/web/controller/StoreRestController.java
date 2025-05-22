package umc.spring.web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.StoreService.StoreService;
import umc.spring.web.dto.StoreRequestDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreService storeService;

    //가게 추가하는 api
    @PostMapping("/")
    public ApiResponse<Null> addStore(@RequestBody @Valid StoreRequestDTO.JoinStoreDTO request){
        storeService.storeSave(request);
        return ApiResponse.onSuccess(null);
    }
}
