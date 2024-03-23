package com.inn.cafe.service;

import com.inn.cafe.dao.UserDao;
import com.inn.cafe.model.User;
import com.inn.cafe.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

import static com.inn.cafe.constants.CafeConstants.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup {}", requestMap);
        try {

            if (validateSignUpMap(requestMap)) {
                User user = userDao.findByEmail(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userDao.save(getUserFromMap(requestMap));
                    return CafeUtils.getResponseEntity(SUCCESSFUL_REGISTER, HttpStatus.OK);
                }
                return CafeUtils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
            }
            return CafeUtils.getResponseEntity(INVALID_DATA, HttpStatus.BAD_REQUEST);

        }catch (Exception e){
            e.printStackTrace();
        }
        return CafeUtils.getResponseEntity(SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        return requestMap.containsKey("name") &&
                requestMap.containsKey("contactNumber") &&
                requestMap.containsKey("email") &&
                requestMap.containsKey("password");


    }

    private User getUserFromMap(Map<String, String> requestMap){
       return User.builder()
                .name(requestMap.get("name"))
                .contactNumber(requestMap.get("contactNumber"))
                .email(requestMap.get("email"))
                .password(requestMap.get("password"))
                .status(requestMap.get("status"))
                .role(requestMap.get("role"))
                .build();
    }

}
