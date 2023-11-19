package com.springboot.learnjpaandhibernate.course.jdbc;

import com.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) {
        repository.createTable();
        repository.insertData(new Course(1L,"Learn AWS", "in28minutes"));
        repository.insertData(new Course(2L,"Learn Kotlin", "in28minutes"));
        repository.insertData(new Course(3L,"Learn Ktor", "in28minutes"));
        repository.deleteData(1L);

        var course = repository.selectById(2L);
        System.out.println(course);

    }
}