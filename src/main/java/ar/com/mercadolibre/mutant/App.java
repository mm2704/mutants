package ar.com.mercadolibre.mutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = "ar.com.mercadolibre.mutant")
@EntityScan(basePackages = "ar.com.mercadolibre.mutant")
public class App {
	
	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(App.class);
		sa.run(args);
	}
	
 	
}
    
