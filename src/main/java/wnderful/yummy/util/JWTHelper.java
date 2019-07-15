package wnderful.yummy.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTHelper {
    private final String login_secret = "secret";

    public String createToken(String username,String type)throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        return JWT.create()
                .withHeader(map)
                .withClaim("username", username)
                .withClaim("type", type)
                .sign(Algorithm.HMAC256(login_secret));
    }

    public String[] verifyToken(String token) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(login_secret))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        String[] result = new String[3];
        result[0] = claims.get("username").asString();
        result[1] = claims.get("type").asString();
        return result;
    }
}
