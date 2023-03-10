package com.example.Book_my_Show.Controller;

import com.example.Book_my_Show.EntryDtos.MovieEntryDto;
import com.example.Book_my_Show.ResponseDtos.MovieResponseDto;
import com.example.Book_my_Show.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){

        try{
            String result = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            String response = "Movie not added";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get/{name}")
    public ResponseEntity<MovieResponseDto> getMovieByName(@PathVariable String name) throws Exception{
        MovieResponseDto movieResponseDto = movieService.getMoviesByName(name);
        return new ResponseEntity<>(movieResponseDto,HttpStatus.FOUND);

    }
}
