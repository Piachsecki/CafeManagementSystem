package com.inn.cafe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping(path = "/user")
public interface UserController {
    @PostMapping(path = "/signUp")
    ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap);

}
