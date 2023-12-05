package com.felas.ambieep.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptoHash {
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512"); //1

            byte[] hashedBytes = md.digest(password.getBytes()); //1

            StringBuilder stringBuilder = new StringBuilder();//1
            for (byte b : hashedBytes) { //n
                stringBuilder.append(String.format("%02x", b));//1
            }

            return stringBuilder.toString(); //1

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();//1
            return null; //1
        }


    }
}
