package com.ljw.gateway.v2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 代码处理网关的转发
 * 
 * @author PC
 *
 */
@SpringBootApplication
public class GatewayV2Application {
	
	private static final Logger log = LoggerFactory.getLogger(GatewayV2Application.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GatewayV2Application.class);
		ConfigurableApplicationContext applicationContext = app.run(args);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String port = environment.getProperty("server.port");
		String serverName = environment.getProperty("spring.application.name");
		log.info("\n----------------------------------------------------------\n\t"
				+ "Application {} is running! Access URLs:\n\t" + // 大括号1
				"Local: \t\thttp://localhost:{}\n\t" + // 大括号2
				"{}\n\t" + // 大括号3
				"\n----------------------------------------------------------",
				serverName, // 大括号1对应的内容
				port, // 大括号2对应的内容
				"Thank You!"// 大括号4对应的内容
				
				);
	}
}
