package ycu.edu.ygc.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.Map;

/**
 * @author WYJ
 * @software: IntelliJ IDEA
 * @date 2023/4/4 23:19
 */
public class JwtUtil {

    public static String secretKey = "helloWorld";

    public static Long ttlMillis = 7 * 24 * 60 * 60 * 1000L;

    public static String createJWT(String id, String subject, Long ttlMillis, Map<String, Object> map) {
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject) // 发行者
                .setIssuedAt(new Date()) // 发行时间
                .signWith(SignatureAlgorithm.HS256, secretKey) // 签名类型 与 密钥
                .compressWith(CompressionCodecs.DEFLATE);// 对载荷进行压缩
        if (!CollectionUtils.isEmpty(map)) {
            builder.setClaims(map);
        }
        if (ttlMillis > 0) {
            builder.setExpiration(new Date(System.currentTimeMillis() + ttlMillis));
        }
        return builder.compact();
    }


    public static Claims parseJWT(String jwtString) {
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(jwtString)
                .getBody();
    }
}
