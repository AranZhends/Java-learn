package org.example.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileCopyTest {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("F:\\Frank\\个人资料\\head.jpg");

        FileOutputStream fos = new FileOutputStream("F://1.jpg");

        byte[] bytes = new byte[1024];
        int len;//读取时的赋值
        while ((len = is.read(bytes))!=-1) {
            fos.write(bytes,0,len);
        }

        is.close();
        fos.close();

    }
}
