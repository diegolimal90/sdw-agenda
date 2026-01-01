package br.com.sdweb.agenda.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(
//        exclude = {
//                MongoAutoConfiguration.class
//        }
)
@ComponentScan({
        "br.com.sdweb.agenda.configuration",
        "br.com.sdweb.agenda.entrypoint",
        "br.com.sdweb.agenda.entrypoint.controller.api",
        "br.com.sdweb.agenda.repository",
        "br.com.sdweb.agenda"
})
@EnableMongoRepositories(basePackages = "br.com.sdweb.agenda.repository")
public class AgendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgendaApplication.class, args);
    }

}
