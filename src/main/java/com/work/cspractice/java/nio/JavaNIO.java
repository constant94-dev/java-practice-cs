package com.work.cspractice.java.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class JavaNIO {
    public void createFileAndRead() {
        try {
            // '.txt' 확장자를 가진 임시 파일을 만든다
            Path path = Files.createTempFile("test-file", ".txt");
            Iterable<String> iterable = Arrays.asList("Hello", "world");
            Files.write(path, iterable);
            // Path 객체에 의해 정의된 파일에서 모든 바이트를 읽는다
            byte[] bytes = Files.readAllBytes(path);
            // new String() 생성자 사용해 문자열로 변환
            System.out.println(new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
