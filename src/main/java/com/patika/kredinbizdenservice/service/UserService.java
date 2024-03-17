package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
    }

    public static void addUser(User newUser) throws NoSuchAlgorithmException {
        if (isUserExists(newUser.getEmail())) {
            System.out.println("Hata: '" + newUser.getEmail() + "' bu e-mail adresiyle kayıtlı bir kullanıcı zaten var.");
        } else {
            newUser.setPassword(encryptPasswordSHA512(newUser.getPassword()));
            userList.add(newUser);
            System.out.println(newUser.getEmail() + " adresiyle yeni kullanıcı basariyla eklendi.");
        }
    }


    public static boolean isUserExists(String email) {
        return userList.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }

    public static String encryptPasswordSHA512(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
