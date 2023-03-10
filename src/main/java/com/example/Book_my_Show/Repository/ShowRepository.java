package com.example.Book_my_Show.Repository;

import com.example.Book_my_Show.Entities.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {

}
