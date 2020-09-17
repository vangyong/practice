package cn.segema.learn.interview.jwt;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;

import java.util.Base64.Encoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @description 一句话描述该类的功能
 * @author wangyong
 * @createDate 2020/09/17
 */
public class JwtDemo {
    private static final String SECRET = "9a96349e2345385785e804e0f4254dee";

    private static String ISSUER = "sys_user";

    /**
     * 生成token
     * @param claims
     * @param expireDatePoint  过期时间点
     * @return
     */
    public static String genToken(Map<String, String> claims, Date expireDatePoint) {
        try {
            // 使用HMAC256进行加密
            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            // 创建jwt
            JWTCreator.Builder builder = JWT.create().withIssuer(ISSUER). // 发行人
                withExpiresAt(expireDatePoint); // 过期时间点

            // 传入参数
            claims.forEach((key, value) -> {
                builder.withClaim(key, value);
            });

            // 签名加密
            return builder.sign(algorithm);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 解密jwt
     * @param token
     * @return
     * @throws RuntimeException
     */
    public static Map<String, String> verifyToken(String token) throws RuntimeException {
        Algorithm algorithm = null;
        try {
            // 使用HMAC256进行加密
            algorithm = Algorithm.HMAC256(SECRET);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        // 解密
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> map = jwt.getClaims();
        Map<String, String> resultMap = new HashMap<>();
        map.forEach((k, v) -> resultMap.put(k, v.asString()));
        return resultMap;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Map<String, String> claims = new HashMap<String, String>();
        claims.put("userName", "ceshi");
        claims.put("departmentName", "研发部");
        claims.put("yunwei", "运维部");
        Date expireDatePoint = new Date();
        expireDatePoint.setDate(expireDatePoint.getDate() + 7);
        String token = genToken(claims, expireDatePoint);
        System.out.println(token);
        Map<String, String> map = verifyToken(token);
        System.out.println(map);

        // 手工验证
        Encoder BASE64_URL_ENCODER = Base64.getUrlEncoder().withoutPadding();
        
        JSONObject headerJsonObject = new JSONObject();
        headerJsonObject.put("typ", "JWT");
        headerJsonObject.put("alg", "HS256");
        String headerJsonObjectString = headerJsonObject.toString();
        String base64HeaderString = BASE64_URL_ENCODER.encodeToString(headerJsonObjectString.getBytes());
        System.out.println("---herder BASE64---");
        System.out.println(base64HeaderString);
        
        JSONObject payloadJsonObject = new JSONObject();
        payloadJsonObject.put("userName", "ceshi");
        payloadJsonObject.put("departmentName", "研发部");
        payloadJsonObject.put("yunwei", "维部");
        payloadJsonObject.put("iss", "sys_user");
        payloadJsonObject.put("exp", expireDatePoint);
        
        String payloadJsonObjectString = payloadJsonObject.toString();
        String base64PayloadString = BASE64_URL_ENCODER.encodeToString(payloadJsonObjectString.getBytes());
        System.out.println("---payload BASE64---");
        System.out.println(base64PayloadString);
        
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        sha256_HMAC.getAlgorithm();

    }
}
