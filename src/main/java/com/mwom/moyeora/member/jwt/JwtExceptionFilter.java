package com.mwom.moyeora.member.jwt;

import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtExceptionFilter extends OncePerRequestFilter {


  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
    try {
      chain.doFilter(request, response);
    } catch (JwtException ex) {
      String message = ex.getMessage();

        setResponse(response, message);

    }
  }

  private void setResponse(HttpServletResponse response, String errorMessage) throws RuntimeException, IOException {
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().print(errorMessage);
  }
}