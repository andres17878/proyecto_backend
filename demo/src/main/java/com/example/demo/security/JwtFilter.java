package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {


    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserDetailsService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, java.io.IOException {

        String token = this.extractToken(request);

        if(this.tokenProvider.isValidToken(token)){

            String username = this.tokenProvider.getUsernameFromToken(token);
            UserDetails user = this.userService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith("Bearer")){
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }
}
