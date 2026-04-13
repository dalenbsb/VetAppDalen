package com.dalen.vetAppDalen.testeapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteApiController {
	
	@Value("${spring.profiles.active:prod}")
	private String profile;
	
	@GetMapping("/api/hello")
    public String hello() {
        return "Hello World, Dalembert Menezes Cruz agora com Deploy automático (" + profile + ")";
    }

}
