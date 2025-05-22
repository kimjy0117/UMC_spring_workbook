package umc.spring.service.StoreService;

import umc.spring.web.dto.StoreRequestDTO;

public interface StoreService {
    void storeSave(StoreRequestDTO.JoinStoreDTO joinStoreDTO);
}
