package br.com.zup.veiculo.desafio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class Desafio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

}
