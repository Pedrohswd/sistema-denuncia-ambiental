package com.felas.ambieep.utils;

public class Password {
    public static boolean validatePass(String passUser, String passInput){
        if(passUser.equals(passInput)){
            return true;
        }
        return false;
    }
}
