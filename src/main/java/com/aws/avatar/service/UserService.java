package com.aws.avatar.service;

import com.aws.avatar.api.dto.UserDTORequest;
import com.aws.avatar.config.S3StorageAdapter;
import com.aws.avatar.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final S3StorageAdapter s3StorageAdapter;

    public UserService(S3StorageAdapter s3StorageAdapter) {
        this.s3StorageAdapter = s3StorageAdapter;
    }

    public User save(UserDTORequest userDTORequest) throws IOException {

        String urlAvatarCallback = s3StorageAdapter
                .uploadFile(userDTORequest.file().getBytes(), userDTORequest.file().getName(), userDTORequest.file().getContentType());

        User user = User.from(userDTORequest.name(), urlAvatarCallback);
        return user;
    }

}
