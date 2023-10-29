package com.yicj.study.hello.reposotory.mapper;

import com.yicj.study.hello.reposotory.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository ;


    @Test
    void findAll() {
        List<City> list = cityRepository.findAll();
        log.info("list size : {}", list.size());
    }

    @Test
    void findByNameAndStateAllIgnoringCase() {
        org.springframework.data.repository.Repository repository;
        String name = "BJS" ;
        String status = "UP" ;
        City city = cityRepository.findByNameAndStateAllIgnoringCase(name, status);
        log.info("city : {}", city);
        EntityManager entityManager ;
    }

    @Test
    void addCity(){
        City city = new City() ;
        city.setId(1L);
        city.setName("BJS");
        city.setState("UP");
        cityRepository.save(city) ;

        //
        List<City> list = cityRepository.findAll();
        log.info("list size : {}", list.size());
        list.forEach(item -> log.info("====> item : {}", item));
    }
}