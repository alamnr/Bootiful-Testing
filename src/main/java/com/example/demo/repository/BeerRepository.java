package com.example.demo.repository;

import com.example.demo.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BeerRepository extends JpaRepository<Beer, Long>{

    Collection<Beer> findByName(String name);
}
