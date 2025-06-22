package com.aws.avatar.api.dto;

import org.springframework.web.multipart.MultipartFile;

public record UserDTORequest(
        String id,
        String name,
        MultipartFile file
) {
}
