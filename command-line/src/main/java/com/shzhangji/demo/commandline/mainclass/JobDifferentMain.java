package com.shzhangji.demo.commandline.mainclass;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JobDifferentMain implements CommandLineRunner {
  public static void main(String[] args) {
    SpringApplication.run(JobDifferentMain.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("Run JobDifferentMain");
  }
}
