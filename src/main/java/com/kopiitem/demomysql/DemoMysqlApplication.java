package com.kopiitem.demomysql;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.stream.Stream;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class DemoMysqlApplication {

    public static void main(String[] args) {
        try {
            Thread.sleep(10000l);
            SpringApplication.run(DemoMysqlApplication.class, args);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


@Component
class CL implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream.of(new User("Donny"), new User("Wice"), new User("Kensei")).forEach(userRepository::save);
    }
}


@RepositoryRestResource
interface UserRepository extends JpaRepository<User, Long> {

}


@Entity
@Getter
@Setter
@NoArgsConstructor
class User {
    @Id
    @GeneratedValue
    Long id;
    String name;

    public User(String name) {
        this.name = name;
    }
}