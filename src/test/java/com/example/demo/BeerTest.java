package com.example.demo;

import com.example.demo.domain.Beer;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BeerTest {

    @Test
    public void creation(){
        Beer beer = new Beer(1L,"Teddy", "Good");

        Assert.assertEquals(beer.getId(),(Long)1L);
        Assert.assertThat(beer.getId(), Matchers.equalTo(1L));

        Assertions.assertThat(beer.getId()).isEqualTo(1L);
        Assertions.assertThat(beer.getName()).isNotBlank();
        Assertions.assertThat(beer.getName()).isEqualTo("Teddy");

    }

}
