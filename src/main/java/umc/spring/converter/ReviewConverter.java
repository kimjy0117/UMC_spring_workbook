package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.ReviewDTO reviewDTO, Member member, Store store){
        return Review.builder()
                .body(reviewDTO.getBody())
                .score(reviewDTO.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
