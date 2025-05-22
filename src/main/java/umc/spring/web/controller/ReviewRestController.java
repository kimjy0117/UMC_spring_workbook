package umc.spring.web.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.ReviewService.ReviewService;
import umc.spring.web.dto.ReviewRequestDTO;

@Valid
@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewService reviewService;

    //리뷰 추가 컨트롤러
    @PostMapping("/")
    public ApiResponse<Null> addReview(@RequestBody @Valid ReviewRequestDTO.ReviewDTO request){
        reviewService.reviewSave(request);
        return ApiResponse.onSuccess(null);
    }

}
