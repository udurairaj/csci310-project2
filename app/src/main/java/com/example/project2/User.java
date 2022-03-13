package com.example.project2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class User {

    private int userID;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String profilePic;
    private String[] otherInfo;
    //private Event[] events;

    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = hash(password);
        if (this.password != null) {
            // ADD USER TO DB
        }
        else {
            // ERROR
        }
    }

    public int getUserID() { return userID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getUsername() { return username; }
    public String getProfilePic() { return profilePic; }
    public String[] getOtherInfo() { return otherInfo; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) {
        String hashedPass = hash(password);
        if (hashedPass != null) {
            // UPDATE USER DB PASSWORD
        }
        else {
            // ERROR MESSAGE
        }
    }
    public void setProfilePic(String profilePic) { this.profilePic = profilePic; }
    public void setOtherInfo(String[] otherInfo) { this.otherInfo = otherInfo; }

    public Boolean validate(String username, String password) {
        // SEARCH DB FOR USERNAME
        // CHECK THAT HASHED PW MATCHES DB PASSWORD
        return true;
        //OTHERWISE RETURN FALSE
    }

    private String hash(String password) {
        String hashedPass = null;
        try {
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            rand.nextBytes(salt);
            String saltStr = salt.toString();

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(saltStr.getBytes());
            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            hashedPass = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPass;
    }

}
