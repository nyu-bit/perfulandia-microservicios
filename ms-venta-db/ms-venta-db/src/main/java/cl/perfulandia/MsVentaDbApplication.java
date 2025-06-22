package cl.perfulandia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "cl.perfulandia.model.entities")
@EnableJpaRepositories(basePackages = "cl.perfulandia.model.repositories")
@SpringBootApplication
public class MsVentaDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsVentaDbApplication.class, args);
	}	
}