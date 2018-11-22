package com.example.demo;

import com.example.demo.domain.Beer;
import com.example.demo.repository.BeerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class BeerRepositoryTest {

    @Autowired
    private BeerRepository beerRepository;

    @Test
    public void findByBeerName(){

        this.beerRepository.save(new Beer(null,"Teddy","Good"));

        Collection<Beer> beers = this.beerRepository.findByName("Teddy");

        assertThat(beers.size()).isEqualTo(1);
        assertThat(beers.iterator().next().getId()).isGreaterThan(0);
        assertThat(beers.iterator().next().getName()).isEqualTo("Teddy");

    }

}
