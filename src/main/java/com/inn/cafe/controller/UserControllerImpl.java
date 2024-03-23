package com.inn.cafe.controller;

import com.inn.cafe.service.UserService;
import com.inn.cafe.utils.CafeUtils;
import jakarta.persistence.NamedQuery;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.inn.cafe.constants.CafeConstants.SOMETHING_WENT_WRONG;


@RestController
public class UserControllerImpl implements UserController{

    @Autowired
    private UserService userService;


    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
       return CafeUtils.getResponseEntity(SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
