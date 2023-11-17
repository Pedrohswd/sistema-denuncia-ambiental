package com.felas.ambieep.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptoHash {
    public static String hashPassword(String password) {
        try {
            // Cria uma instância do MessageDigest com o algoritmo SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // Converte a senha para bytes e aplica o hash
            byte[] hashedBytes = md.digest(password.getBytes());

            // Converte os bytes hash para uma representação hexadecimal
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Lida com a exceção, por exemplo, lançando-a novamente ou retornando um valor padrão
            return null;
        }


    }
}
