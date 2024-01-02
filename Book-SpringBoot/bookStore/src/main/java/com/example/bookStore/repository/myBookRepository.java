package com.example.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookStore.entity.myBook;

@Repository
public interface myBookRepository extends JpaRepository<myBook, Integer> {

}