package com.mvc.boot;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration //설정파일인 xml문서를 대신해 bean을 생성해주는 클래스임을 annotation
@EnableSwagger2 //Controller에 붙여놓은 annotation 활성화
public class SwaggerConfig {

//	Swagger 설정 확인
//	http://localhost/v2/api-docs
//	Swagger-UI 확인
//	http://localhost/swagger-ui.html
	
	@Bean //<bean id="api" class="Docket"/>
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				    .select()//initiates
					.apis(RequestHandlerSelectors.basePackage("com.mvc.boot.controller"))				
					.paths(regex("/*/*.*")) //정규표현식을 사용해 어떤 경로를 입력하는지 판별				
					.build()
					.apiInfo(info());
	}
	
	private ApiInfo info() {
		return new ApiInfoBuilder()
				.title("HappyHouse API")
				.description("<h2>HappyHouse Service</h2>Swagger를 이용한 HappyHouse API<br>")
				.version("1.0")
				.build();
	}

}