package com.satendra.springbootoauth2passwordflow.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args) {

        System.out.println(bCryptpasswordEncoder("satendra1"));
    }

    static String bCryptpasswordEncoder(String rawPassword){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(rawPassword);
    }
}
