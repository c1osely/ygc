package ycu.edu.ygc.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/5 0:27
 */
public class Md5Utils {

    @Value("${md5.salt}")
    private static String salt;

    public static String getMd5Password(String password){
        return DigestUtils.md5DigestAsHex((password + salt).getBytes());
    }

}
