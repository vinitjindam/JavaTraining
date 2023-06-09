package com.crudplayer.crudplayerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CrudplayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudplayerApplication.class, args);
	}

}
