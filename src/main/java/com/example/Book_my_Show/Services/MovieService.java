package com.example.Book_my_Show.Services;


import com.example.Book_my_Show.Entities.MovieEntity;
import com.example.Book_my_Show.EntryDtos.MovieEntryDto;
import com.example.Book_my_Show.Repository.MovieRepository;
import com.example.Book_my_Show.ResponseDtos.MovieResponseDto;
import com.example.Book_my_Show.convertors.MovieConvertors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto)throws Exception{


        MovieEntity movieEntity = MovieConvertors.convertEntryDtoToEntity(movieEntryDto);

        movieRepository.save(movieEntity);

        return "Movie Added successfully";


    }

    public MovieResponseDto getMoviesByName(String name) throws Exception {
        MovieResponseDto movieResponseDto=new MovieResponseDto();
        List<MovieEntity> movieEntityList =movieRepository.findAll();
        for(MovieEntity movieEntity:movieEntityList){
            if(movieEntity.getMovieName().equals(name)){
                movieResponseDto=MovieConvertors.convertEntityToResponse(movieEntity);
                return movieResponseDto;
            }
            else
                throw new Exception("movie not found");

        }
        return movieResponseDto;
    }
}
