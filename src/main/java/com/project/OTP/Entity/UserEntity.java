package com.project.OTP.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="otp")
public class UserEntity {
    @Id
    @Column(name="email")
    private String email;
    @Column(name="otp")
    private Integer otp;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
