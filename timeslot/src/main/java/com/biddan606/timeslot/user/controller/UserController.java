package com.biddan606.timeslot.user.controller;

import com.biddan606.timeslot.user.controller.request.UserCreateRequest;
import com.biddan606.timeslot.user.controller.response.UserCreateResponse;
import com.biddan606.timeslot.user.service.UserDto;
import com.biddan606.timeslot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserCreateResponse> create(@RequestBody UserCreateRequest request) {
        UserDto createdUserDto = userService.create(request.toCommand());

        UserCreateResponse response = UserCreateResponse.from(createdUserDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
}
