package cl.perfulandia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "cl.perfulandia.clients")
public class MsVentaBsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsVentaBsApplication.class, args);
    }
}