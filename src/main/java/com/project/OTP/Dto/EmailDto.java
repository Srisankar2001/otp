package com.project.OTP.Dto;

import org.springframework.stereotype.Component;

@Component
public class EmailDto {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
