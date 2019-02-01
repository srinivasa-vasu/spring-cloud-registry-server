package io.spring.registryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableEurekaServer
public class RegistryserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryserverApplication.class, args);
	}

	@Configuration
	class WebSecurity extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().requestMatchers(EndpointRequest.toAnyEndpoint())
					.permitAll().and().httpBasic().disable().csrf().disable();
		}
	}

}
