package com.pb.citizen_api.utils;

import com.pb.citizen_api.constants.AppConstants;

import java.util.Random;

public class PasswordUtil {

    public static String generatePassword(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        // Generate each character of the password randomly from the character set
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(AppConstants.CHARACTERS.length());
            sb.append(AppConstants.CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

}
