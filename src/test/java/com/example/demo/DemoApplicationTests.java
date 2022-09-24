package com.example.demo;

import com.example.mastercode.MasterCodeApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {MasterCodeApp.class})
class DemoApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertTrue(true);
	}

}
