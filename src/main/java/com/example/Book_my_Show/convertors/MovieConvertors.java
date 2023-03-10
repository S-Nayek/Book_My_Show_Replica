package com.example.Book_my_Show.convertors;

import com.example.Book_my_Show.Entities.MovieEntity;
import com.example.Book_my_Show.EntryDtos.MovieEntryDto;
import com.example.Book_my_Show.ResponseDtos.MovieResponseDto;

public class MovieConvertors {


    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){

        MovieEntity movieEntity = MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre()).language(movieEntryDto.getLanguage()).ratings(movieEntryDto.getRatings()).build();

        return movieEntity;
    }
    public static MovieResponseDto convertEntityToResponse(MovieEntity movieEntity){
        return MovieResponseDto.builder().movieName(movieEntity.getMovieName()).duration(movieEntity.getDuration())
                .language(movieEntity.getLanguage()).ratings(movieEntity.getRatings()).genre(movieEntity.getGenre()).build();
    }
}
