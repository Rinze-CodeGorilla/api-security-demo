package com.shzhangji.demo.boot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "job", havingValue = "CountUser")
public class CountUser implements CommandLineRunner {
  private final JdbcTemplate jdbcTemplate;

  @Override
  public void run(String... args) {
    var count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `user`", Integer.class);
    log.info("User count: {}", count);
  }
}
