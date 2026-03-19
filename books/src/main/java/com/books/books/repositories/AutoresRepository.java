package com.books.books.repositories;

import com.books.books.models.AutoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresRepository extends JpaRepository<AutoresModel, Long> {
}
