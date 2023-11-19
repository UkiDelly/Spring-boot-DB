package com.springboot.learnjpaandhibernate.course.jpa;

import com.springboot.learnjpaandhibernate.course.Course;
import com.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) {
        repository.insert(new Course(1L,"Learn AWS", "in28minutes"));
        repository.insert(new Course(2L,"Learn Kotlin", "in28minutes"));
        repository.insert(new Course(3L,"Learn Ktor", "in28minutes"));
        repository.deleteById(1L);

    }
}