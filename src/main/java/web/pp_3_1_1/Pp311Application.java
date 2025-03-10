package web.pp_3_1_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("web")
@EntityScan("web.model")
@EnableJpaRepositories("web.repository")
public class Pp311Application {

    public static void main(String[] args) {
        SpringApplication.run(Pp311Application.class, args);
    }

}
