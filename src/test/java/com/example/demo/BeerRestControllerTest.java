package com.example.demo;

import com.example.demo.domain.Beer;
import com.example.demo.repository.BeerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@WebMvcTest
@RunWith(SpringRunner.class)
public class BeerRestControllerTest {

    /* @Configuration
     public static class MyConfig{
         @Bean
         BeerRepository beerRepository(){
             BeerRepository mock = mock(BeerRepository.class);
             when(mock.findAll()).thenReturn(Arrays.asList(new Beer(1L,"Teddy","Good")));
             return mock;

         }
     }*/

    @MockBean
    private BeerRepository beerRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getBeers() throws Exception {

        when(this.beerRepository.findAll()).thenReturn(Arrays.asList(new Beer(1L,"Teddy","Good")));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/beers"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].name").value("Teddy"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
