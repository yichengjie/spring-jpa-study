package com.yicj.study.hello.reposotory.mapper;

import com.yicj.study.hello.reposotory.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author yicj
 * @date 2023/10/26 21:36
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long>, QuerydslPredicateExecutor<City> {

    //Page<City> findAll(Pageable pageable);

    City findByNameAndStateAllIgnoringCase(String name, String state);

}
