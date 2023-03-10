package com.example.Book_my_Show.convertors;

import com.example.Book_my_Show.Entities.ShowEntity;
import com.example.Book_my_Show.EntryDtos.ShowEntryDto;

public class Showconvertors {


    public static ShowEntity convertEntryToEntity(ShowEntryDto showEntryDto){

        ShowEntity showEntity = ShowEntity.builder()
                .showDate(showEntryDto.getLocalDate())
                .showTime(showEntryDto.getLocalTime())
                .showType(showEntryDto.getShowType())
                                .build();

        return showEntity;
    }
}
