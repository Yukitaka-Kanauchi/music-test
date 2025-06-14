package com.example.demo.form;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AlbumForm {
    private String title;
    private String artist;
    private LocalDate releaseDate;
}
