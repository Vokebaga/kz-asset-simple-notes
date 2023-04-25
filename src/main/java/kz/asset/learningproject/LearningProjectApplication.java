package kz.asset.learningproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LearningProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningProjectApplication.class, args);
    }

}
