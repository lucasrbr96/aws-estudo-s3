package com.aws.avatar.api.controller;

import com.aws.avatar.api.dto.UserDTORequest;
import com.aws.avatar.api.dto.UserDTOResponse;
import com.aws.avatar.model.User;
import com.aws.avatar.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<UserDTOResponse> save(UserDTORequest userDTORequest){
        try {
            User user = service.save(userDTORequest);
            UserDTOResponse userDTOResponse = new UserDTOResponse(user.getId(), user.getName(), user.getUrlAvatar());
            return ResponseEntity.status(HttpStatus.CREATED).body(userDTOResponse);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }
}
