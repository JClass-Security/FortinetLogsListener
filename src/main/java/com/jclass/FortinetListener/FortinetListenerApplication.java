package com.jclass.FortinetListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FortinetListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortinetListenerApplication.class, args);
		//514 is a port no
		new ServerListener(514).start();
	}

}
