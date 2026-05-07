package service;


import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    public static String hashPass(String pass) {
        int logRounds = 12;
        String salt = BCrypt.gensalt(logRounds);
        return BCrypt.hashpw(pass,salt);
    }

    public static boolean checkPass(String pass, String hash){
            return BCrypt.checkpw(pass,hash);
        }

}
