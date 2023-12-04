package com.bigodebombado.backend.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.bigodebombado.backend.Model.User.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(User user){
        try {
            System.out.println(user);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("dynamic-resume")
                    .withSubject(user.getUsername())
                    .withClaim("firstName", user.getFirstName())
                    .withClaim("lastName", user.getLastName())
                    .withClaim("email", user.getEmail())
                    .withClaim("exp1", user.getExp1())
                    .withClaim("empresa1", user.getEmpresa1())
                    .withClaim("period1", user.getPeriod1())
                    .withClaim("exp2", user.getExp2())
                    .withClaim("empresa2", user.getEmpresa2())
                    .withClaim("period2", user.getPeriod2())
                    .withClaim("exp3", user.getExp3())
                    .withClaim("empresa3", user.getEmpresa3())
                    .withClaim("period3", user.getPeriod3())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Error while generation token", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("dynamic-resume")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch(JWTVerificationException exception) {
            return "";
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
