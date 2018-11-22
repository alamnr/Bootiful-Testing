package com.example.demo;

import com.example.demo.domain.Beer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class BeerJpaTest {

    @Autowired
    private TestEntityManager tem;

    @Test
    public void mapping(){
    Beer teddy = this.tem.persistFlushFind(new Beer(null,"Teddy","Good"));
        assertThat(teddy.getName()).isEqualTo("Teddy");
        assertThat(teddy.getId()).isNotNull();
        assertThat(teddy.getId()).isGreaterThan(0);
    }

}
