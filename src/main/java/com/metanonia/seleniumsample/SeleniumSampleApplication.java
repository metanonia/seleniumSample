package com.metanonia.seleniumsample;

import com.metanonia.seleniumsample.util.WebDriverUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumSampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SeleniumSampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        WebDriverUtil webDriverUtil = new WebDriverUtil();
        webDriverUtil.useDriver("https://finance.naver.com");
    }
}
