package com.biddan606.timeslot.user.controller;

import com.biddan606.timeslot.user.controller.request.UserCreateRequest;
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
    public ResponseEntity<Long> create(@RequestBody UserCreateRequest request) {
        Long createdUserId = userService.create(request.toCommand());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdUserId);
    }
}
