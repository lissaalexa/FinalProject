package homestay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "homestay")
@EntityScan(basePackages = "homestay.entity")
public class HomestayApplication {
	public static void main(String[] args) {
		SpringApplication.run(HomestayApplication.class, args);
	}
}
