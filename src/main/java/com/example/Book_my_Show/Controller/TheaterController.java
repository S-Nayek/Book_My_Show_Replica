package com.example.Book_my_Show.Controller;


import com.example.Book_my_Show.EntryDtos.TheaterEntryDto;
import com.example.Book_my_Show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity addTheater(@RequestBody TheaterEntryDto theaterEntryDto){

        try{
            String result = theaterService.addTheater(theaterEntryDto);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getNearTheater")
    public ResponseEntity getNearByTheater(@RequestParam("name") String location){
        try {
            return new ResponseEntity(theaterService.getNearByTheater(location),HttpStatus.FOUND);
        }
        catch(Exception e){
            return new ResponseEntity("no such theater found",HttpStatus.NOT_FOUND);
        }
    }
}
