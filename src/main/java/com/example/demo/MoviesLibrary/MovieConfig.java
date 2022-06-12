package com.example.demo.MoviesLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Year;
import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return args -> {
            Movie killer = new Movie(
                    "Killer",
                    "Juliusz Machulski",
                    Year.of(1997),
                    9.6
            );

            Movie avatar = new Movie(
                    "Avatar",
                    "James Cameron",
                    Year.of(2009),
                    9.3
            );

            movieRepository.saveAll(List.of(killer, avatar));
        };
    }
}
