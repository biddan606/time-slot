package com.biddan606.timeslot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HealthCheckController {

    @GetMapping(
            produces = "text/html; charset=UTF-8"
    )
    public String healthCheck() {
        return "애플리케이션이 실행중입니다!";
    }
}
