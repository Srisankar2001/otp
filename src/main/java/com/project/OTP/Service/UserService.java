package com.project.OTP.Service;

import com.project.OTP.Dto.EmailDto;
import com.project.OTP.Dto.EmailOtpDto;
import com.project.OTP.Entity.UserEntity;
import com.project.OTP.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    Random random = new Random();
    @Autowired
    UserRepo userRepo;

    @Transactional
    public boolean insertOtp(EmailDto emailDto){
        Optional<UserEntity> user = userRepo.findByEmail(emailDto.getEmail());
        if(user.isPresent()){
           int i =  userRepo.deleteByEmail(emailDto.getEmail());
           if(i == 1){
               System.out.println("Already registered email deleted : success");
               int j =   userRepo.addNewMail(emailDto.getEmail(),1000+random.nextInt(9000));
               if(j == 1){
                   System.out.println("OTP added to DB : success");
                   return true;
               }else{
                   System.out.println("OTP added to DB : fail");
                   return false;
               }
           }else{
               System.out.println("Already registered email deleted : fail");
               return false;
           }
        }else{
            int j = userRepo.addNewMail(emailDto.getEmail(),1000+random.nextInt(9000));
            if(j == 1){
                System.out.println("OTP added to DB : success");
                return true;
            }else{
                System.out.println("OTP added to DB : fail");
                return false;
            }
        }
    }

    @Transactional
    public boolean verifyOtp(EmailOtpDto emailOtpDto){
        Optional<UserEntity> user = userRepo.findByEmail(emailOtpDto.getEmail());
        if(user.isPresent()){
            if(user.get().getOtp().equals(emailOtpDto.getOtp())){
                userRepo.deleteByEmail(emailOtpDto.getEmail());
                System.out.println("OTP verified : success");
                return true;
            }else{
                System.out.println("OTP verified : fail");
                return false;
            }
        }else{
            System.out.println("Email is not in the DB");
            return false;
        }
    }
}
