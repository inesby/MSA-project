package com.ForumUI.ForumUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.*;
import org.springframework.cloud.openfeign.*;


@SpringBootApplication
@EnableFeignClients("com.ForumUI")
public class ForumUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumUiApplication.class, args);
	}

}
