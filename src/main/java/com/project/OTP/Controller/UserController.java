package com.project.OTP.Controller;

import com.project.OTP.Dto.EmailDto;
import com.project.OTP.Dto.EmailOtpDto;
import com.project.OTP.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/reg")
    public boolean insertOtp(@RequestBody EmailDto emailDto){
        return userService.insertOtp(emailDto);
    }

    @PostMapping("/ver")
    public boolean verifyOtp(@RequestBody EmailOtpDto emailOtpDto){
        return userService.verifyOtp(emailOtpDto);
    }
}
