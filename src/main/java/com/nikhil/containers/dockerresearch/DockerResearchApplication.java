package com.nikhil.containers.dockerresearch;

import lombok.Lombok;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
@Log4j2
public class DockerResearchApplication {

	static Logger log = LogManager.getLogger(DockerResearchApplication.class);

	public static String userName = "Default Server";

	public static void main(String[] args) {
		log.trace("starting Docker Research Application");
		try {
//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//			userName = reader.readLine();
			System.out.println("On Startup input :: " + userName);
		} catch (Exception e) {
			//System.out.println("System Error: " + e.getMessage());

			log.error("System Error: " + e.getMessage());
			userName = "faulty system";

			log.error("Falling back to default server name: " + userName);
		}
		SpringApplication.run(DockerResearchApplication.class, args);

		log.trace("terminating Docker Research Application");
	}

}
