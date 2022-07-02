package com.shzhangji.demo.requestcontext;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFilter extends OncePerRequestFilter {
  private final CustomContext context;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    var user = new User("Jerry");
    request.setAttribute("user", user);
    context.setUser(user);

    var threadLoadContext = new CustomContext();
    threadLoadContext.setUser(user);
    CustomContextHolder.set(threadLoadContext);

    try {
      filterChain.doFilter(request, response);
    } finally {
      CustomContextHolder.remove();
      log.info("Remove custom context from thread local.");
    }
  }
}
