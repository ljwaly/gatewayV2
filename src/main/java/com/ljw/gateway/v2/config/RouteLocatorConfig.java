package com.ljw.gateway.v2.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		Function<GatewayFilterSpec, UriSpec> fn1 = 
				gatewayFilterSpec -> gatewayFilterSpec.addRequestHeader("Hello", "World");
		
		Function<PredicateSpec, Route.AsyncBuilder> fn = 
				predicateSpec -> predicateSpec.path("/mongdb/*").filters(fn1).uri("http://localhost:8075");
				

				
		return builder.routes().route(fn).build();
	}
	
	
	public static void main(String[] args) {
		String abc = "12345jbc";
		
		Function<String, Integer> fn = abc1 -> Integer.parseInt(abc1.substring(0, 5)) ;
		
		Integer y = fn.apply(abc);
		
		System.out.println(y);
		
		String abc1 = "ljw";
		
		Function<String, Student> fn1 = x -> new Student(x) ;
		
		Student stu = fn1.apply(abc1);
		
		System.out.println(stu);
		
		Thread t = new Thread();
		t.start();
		
	}

}
