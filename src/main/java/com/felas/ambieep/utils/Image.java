package com.felas.ambieep.utils;

import java.util.Base64;

public class Image {

    public static byte[] convertBase64ToByte(String base64){
        return Base64.getDecoder().decode(base64);
    }

    public static String convertByteToBase64(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }
}
