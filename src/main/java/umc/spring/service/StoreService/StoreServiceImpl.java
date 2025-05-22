package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;

    //store를 저장하는 서비스 구현
    @Override
    public void storeSave(StoreRequestDTO.JoinStoreDTO joinStoreDTO) {
        log.info("JoinStoreDTO: " + joinStoreDTO.getName());
        Region region = regionRepository.findByName(joinStoreDTO.getRegion());

        Store store = StoreConverter.toStore(joinStoreDTO, region);
        log.info("Store: " + store);
        storeRepository.save(store);
    }
}
