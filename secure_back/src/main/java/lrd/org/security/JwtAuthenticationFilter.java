package lrd.org.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lrd.org.entities.AppUser;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		AppUser appUser = null;
		try {
			 appUser = new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
			 System.out.println("Auth called "+"user = "+appUser.getUsername()+ " password :: "+appUser.getPassword());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
		return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword())
			);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User userSpring = (User)authResult.getPrincipal();
		String jwt = Jwts.builder()
				.setSubject(userSpring.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+ SecurtyConstant.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurtyConstant.SECRETE)
				.claim("roles", userSpring.getAuthorities())
				.compact();
				
		response.setHeader(SecurtyConstant.HEADER_STRING, SecurtyConstant.TOKEN_PREFIX+jwt);
	}
}
