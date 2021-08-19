package com.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtConfig {
//    private static final Log log = LogFactory.getLog(JwtConfig.class);

    String pwdScrect = "123456";
    Long expireTime = 28800000L;
    
    // 外部http请求中 header中 token的 键值
    private String header = "token";

    private static Map<String, String> tokenMap = new HashMap<>();

    /**
     * 生成token
     *
     * @param subject
     * @return
     */
    public String createToken(String subject) {
        Date nowDate = new Date();
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(nowDate);
//        calendar.add(Calendar.DAY_OF_MONTH, 10);
//        Date expireDate = calendar.getTime();

        Date expireDate = new Date(System.currentTimeMillis() + expireTime);
        System.out.println("expireDate: "+expireDate);
        String userToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(subject)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, pwdScrect)
                .compact();
        // 把token添加到缓存中
        tokenMap.put(subject, userToken);
        return userToken;
    }

    public String createRefreshToken(String subject) {
        Date nowDate = new Date();

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(subject)
                .setIssuedAt(nowDate)
                .signWith(SignatureAlgorithm.HS512, pwdScrect)
                .compact();
    }

    /**
     * 获取token中注册信息
     *
     * @param token
     * @return
     */
    public Claims getTokenClaim(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(pwdScrect)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }

    /**
     * 验证token是否过期失效
     *
     * @param expirationTime
     * @return
     */
    public boolean isTokenExpired(Date expirationTime) {
        return expirationTime.before(new Date());
    }

    /**
     * 获取token失效时间
     *
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        return getTokenClaim(token).getExpiration();
    }

    /**
     * 获取用户名从token中
     */
    public String getUsernameFromToken(String token) {
        String username = null;
        try{
            username = getTokenClaim(token).getSubject();
        }catch (ExpiredJwtException e){
            username = e.getClaims().getSubject();
        }
        return username;
//        Claims claims = getTokenClaim(token);
//        return claims.getSubject();
    }

    /**
     * 获取jwt发布时间
     */
    public Date getIssuedAtDateFromToken(String token) {
        return getTokenClaim(token).getIssuedAt();
    }

    // --------------------- getter & setter ---------------------


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Map<String, String> getTokenMap() {
        return tokenMap;
    }
}