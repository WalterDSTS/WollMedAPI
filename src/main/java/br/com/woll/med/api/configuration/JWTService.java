package br.com.woll.med.api.configuration;

import br.com.woll.med.api.user.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JWTService {
  @Value("${api.security.token.secret}")
  private String secret;

  public String generateToken(User user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.create()
          .withIssuer("API Woll.med")
          .withSubject(user.getUsername())
          .withExpiresAt(expiresAt())
          .sign(algorithm);
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Error on generating token", exception);
    }
  }

  public String getSubject(String tokenJWT) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
          .withIssuer("API Woll.med")
          .build()
          .verify(tokenJWT)
          .getSubject();
    } catch (JWTVerificationException exception) {
      throw new RuntimeException("Token JWT invalid or expired");
    }
  }

  private Instant expiresAt() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
}
