package com.work.cspractice;

import com.work.cspractice.java.nio.JavaNIO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsPracticeApplication.class, args);

        JavaNIO nio = new JavaNIO();
        nio.createFileAndRead();
    }
}
