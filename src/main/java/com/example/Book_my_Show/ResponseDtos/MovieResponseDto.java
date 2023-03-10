package com.example.Book_my_Show.ResponseDtos;

import com.example.Book_my_Show.Enums.Genre;
import com.example.Book_my_Show.Enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto {
    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;
}
