package com.shzhangji.demo.commandline.differentpackage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobDifferentPackage implements CommandLineRunner {
  @Override
  public void run(String... args) {
    log.info("Run JobDifferentPackage");
  }
}
