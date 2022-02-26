package com.example.todo_list_server;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;

@SpringBootTest
class TodoListServerApplicationTests {
//JWT获取令牌
    @Test
    void contextLoads() {

        HashMap<String, Object> map = new HashMap<>();

        Calendar instance = Calendar.getInstance(); //日历类
        instance.add(Calendar.SECOND,90); //20秒之后令牌失效

        String token = JWT.create()
                .withHeader(map)    //header
                .withClaim("userid", 21)  //payload
                .withClaim("username", "xiaochen")
                .withExpiresAt(instance.getTime())  //指定令牌过期时间
                .sign(Algorithm.HMAC256("p!Kuq9C(o"));  //签名 C256算法密钥
        System.out.println(token);
    }
    @Test
    public void test(){
        //创建验证对象 反解密
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("p!Kuq9C(o")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NDU4OTk3MTAsInVzZXJpZCI6MjEsInVzZXJuYW1lIjoieGlhb2NoZW4ifQ.jSH1FoprtynqQmPO2WTzf1wXF1PorhO0o61dx8zfG28");
        System.out.println(verify.getClaim("userid").asInt());
        System.out.println(verify.getClaim("username").asString());
        //System.out.println(verify.getClaims().get("userid").asInt());
        //System.out.println(verify.getClaims().get("username").asString());
    }
}
