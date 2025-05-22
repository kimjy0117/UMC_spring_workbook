package umc.spring.service.ReviewService;

import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewService {
    void reviewSave(ReviewRequestDTO.ReviewDTO reviewDTO);
}
