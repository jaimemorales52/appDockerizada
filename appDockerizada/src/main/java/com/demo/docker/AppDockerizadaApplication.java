package com.demo.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AppDockerizadaApplication {

	@Autowired
	private TypeResolver typeResolver;

	@Value("${springfox.paths.pathMapping:/}")
	private String springfoxPathMapping;

	@Value("${app.version}")
	private String appVersion;

	public static void main(String[] args) {
		SpringApplication.run(AppDockerizadaApplication.class, args);
	}

	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.demo.docker.controller")).paths(PathSelectors.any()).build()
				.pathMapping(springfoxPathMapping).genericModelSubstitutes(ResponseEntity.class)
				.alternateTypeRules(AlternateTypeRules.newRule(
						typeResolver.resolve(DeferredResult.class,
								typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
						typeResolver.resolve(WildcardType.class)))
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET,
						Lists.newArrayList(new ResponseMessageBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
								.message("500 message").responseModel(new ModelRef("Error")).build()))
				.enableUrlTemplating(false).apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {

		return new ApiInfo("Demo Docker GT", "Demo Docker REST", appVersion, "urn:tos", new Contact("", "", ""),
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}
}
