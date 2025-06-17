package com.example.demo.entity;
//コメント
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Album {
    private long albumId;
    private String title;
    private String photo;
    private int artist;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private LocalDateTime createdAt;
}
