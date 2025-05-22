package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public void reviewSave(ReviewRequestDTO.ReviewDTO reviewDTO){
        Member member = memberRepository.findByName(reviewDTO.getMemberName());
        Store store = storeRepository.findByName(reviewDTO.getStoreName());

        Review review = ReviewConverter.toReview(reviewDTO, member, store);
        reviewRepository.save(review);
    }
}
