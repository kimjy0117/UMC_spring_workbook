package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public class StoreConverter {

    public static Store toStore (StoreRequestDTO.JoinStoreDTO joinStoreDTO, Region region){
        return Store.builder()
                .name(joinStoreDTO.getName())
                .address(joinStoreDTO.getAddress())
                .score((float) 0)
                .region(region)
                .build();
    }
}
