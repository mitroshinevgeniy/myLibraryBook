package ru.mitroshin.mylibrarybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("ru.mitroshin.mylibrarybook")
public class MyLibraryBookApplication {

    public static void main(String[] args) {SpringApplication.run(MyLibraryBookApplication.class, args);

    }

}
