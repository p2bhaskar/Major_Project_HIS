package com.pb.citizen_api.utils;

import java.util.Random;

public class AppNumUtil {

    private static final String PREFIX = "HIS";

    public static String generateApplicationNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(PREFIX);
        for (int i = 0; i<6; i++) {
            int in = random.nextInt(26) ;
            sb.append(in);
        }
        return sb.toString();
    }
}
