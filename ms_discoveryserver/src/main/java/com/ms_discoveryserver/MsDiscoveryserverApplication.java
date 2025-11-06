package com.ms_discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsDiscoveryserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDiscoveryserverApplication.class, args);
	}

}
