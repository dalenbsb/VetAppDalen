package com.dalen.vetAppDalen.testeapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TesteApiController {
	
	@Autowired
	private Environment env;
	
	@Value("${app.db.name:default}")
	private final String db;
	
	public TesteApiController(Environment env, String db) {
		this.env = env;
		this.db = db;
	}


	@GetMapping("/profile")
	public String getProfile() {
	    return Arrays.toString(env.getActiveProfiles());
	}

	@GetMapping("/db")
	public String db() {
		return db;
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World, Dalembert Menezes Cruz com Deploy automático (" + getProfile() + ")";
	}

}
