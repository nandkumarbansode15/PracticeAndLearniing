package com.springboot.project.controllerproject;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

@SpringBootApplication
@EnableSwagger2
public class ControllerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerProjectApplication.class, args);
	}
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("shop-details")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/shop.*"), regex("/shop.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Shop details API")
				.description("JavaInUse API reference for developers")
				.termsOfServiceUrl("http://none.com").contact(new Contact("Nandkumar", "http://none.com", "nandkumarbansode15@gmail.com"))
				.license("JavaInUse License")
				.licenseUrl("nandkumarbansode15@gmail.com").version("1.0").build();
	}

}
