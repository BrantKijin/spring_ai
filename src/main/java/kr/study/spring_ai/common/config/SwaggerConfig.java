package kr.study.spring_ai.common.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;

/**
 * Aegis API Configuration Example
 * Swagger V3.0 설정 클래스
 */

@Configuration
@Slf4j
public class SwaggerConfig {
	@Bean
	public OpenAPI openAPI() {
		SecurityScheme securityScheme = new SecurityScheme()
			.type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
			.in(SecurityScheme.In.HEADER).name("Authorization");
		SecurityRequirement securityRequirement = new SecurityRequirement().addList("bearerAuth");

		return new OpenAPI()
			.info(new Info()
				.title("SPRING AI ")
				.description("SPRING AI")
				.version("1.0.0"))
			.components(new Components().addSecuritySchemes("bearerAuth", securityScheme))
			.security(Collections.singletonList(securityRequirement));
	}
}
