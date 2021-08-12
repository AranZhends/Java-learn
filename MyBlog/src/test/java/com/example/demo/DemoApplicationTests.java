package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	//读取配置文件中的信息
	@Value("${myimgpath}")
	private String imgPath;

	@Test
	void contextLoads() {
		System.out.println(imgPath);
	}

}
