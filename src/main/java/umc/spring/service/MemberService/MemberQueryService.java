package umc.spring.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import umc.spring.web.dto.MemberResponseDTO;

public interface MemberQueryService {
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
