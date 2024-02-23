package com.example.demo.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	@Value("${app.jwtSemilla}")
	private String jwtSemilla;
	@Value("${app.JwtExpirationMs}")
	private int JwtExpirationMs;

	public String BuildTokenJwt(String nombre) {
		return Jwts.builder().setSubject(nombre).setSubject("Hola MuNDO").setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + this.JwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, this.jwtSemilla).compact();
	}
}
