package com.springboot.learnjpaandhibernate.course.springdatajpa;

import com.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.List;

// JpaRepository는 두가지 제너릭은 받는데, 첫번째 제너릭은 관리하는 Entity 모델이고, 두번째 제너릭은 PK의 타입이다.
public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {

    List<Course> findByAuthor(String author);

    List<Course> findByNameContains(String name);

}