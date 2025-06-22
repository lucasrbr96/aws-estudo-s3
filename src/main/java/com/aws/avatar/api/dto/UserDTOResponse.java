package com.aws.avatar.api.dto;

import org.springframework.web.multipart.MultipartFile;

public record UserDTOResponse(
        String id,
        String name,
        String url
) {
}
