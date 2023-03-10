package com.example.Book_my_Show.Services;


import com.example.Book_my_Show.Entities.TheaterEntity;
import com.example.Book_my_Show.Entities.TheaterSeatEntity;
import com.example.Book_my_Show.EntryDtos.TheaterEntryDto;
import com.example.Book_my_Show.Enums.SeatType;
import com.example.Book_my_Show.Repository.TheaterRepository;
import com.example.Book_my_Show.Repository.TheaterSeatRepository;
import com.example.Book_my_Show.convertors.TheaterConvertors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;


    @Autowired
    TheaterRepository theaterRepository;

    public String addTheater(TheaterEntryDto theaterEntryDto)throws Exception{


        //Do some validations :
        if(theaterEntryDto.getName()==null||theaterEntryDto.getLocation()==null){
            throw new Exception("Name and location should valid");
        }

        TheaterEntity theaterEntity = TheaterConvertors.convertDtoToEntity(theaterEntryDto);
        List<TheaterSeatEntity> theaterSeatEntityList = createTheaterSeats(theaterEntryDto,theaterEntity);

        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);
        theaterRepository.save(theaterEntity);

        return "Theater Added successfully";
    }

    private List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto,TheaterEntity theaterEntity){

        int noClassicSeats = theaterEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theaterEntryDto.getPremiumSeatsCount();

        List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();

        //Created the classic Seats
        for(int count = 1;count<=noClassicSeats;count++){

            //We need to make a new TheaterSeatEntity
            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder()
                    .seatType(SeatType.CLASSIC).seatNo(count+"C")
                    .theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }


        //Create the premium Seats
        for(int count=1;count<=noPremiumSeats;count++){

            TheaterSeatEntity theaterSeatEntity = TheaterSeatEntity.builder().
                    seatType(SeatType.PREMIUM).seatNo(count+"P").theaterEntity(theaterEntity).build();

            theaterSeatEntityList.add(theaterSeatEntity);
        }

        //Not saving the child here
        return theaterSeatEntityList;

    }
    public List<String> getNearByTheater(String location){
        List<String> theaterList =new ArrayList<>();
        List<TheaterEntity> theaterEntityList =theaterRepository.findAll();
        for(TheaterEntity theaterEntity : theaterEntityList){
            if(theaterEntity.getLocation().equals(location)){
                theaterList.add(theaterEntity.getName());
            }
        }
        return theaterList;
    }
}
