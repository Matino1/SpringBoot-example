package com.example.demo.MoviesLibrary;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Year;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String title;
    private String director;
    private Year productionYear;
    private double rating;

    public Movie(@NonNull String title, String director, Year productionYear, double rating) {
        this.title = title;
        this.director = director;
        this.productionYear = productionYear;
        this.rating = rating;
    }
}
