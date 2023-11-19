package com.springboot.learnjpaandhibernate.course.springdatajpa;

import com.springboot.learnjpaandhibernate.course.Course;
import com.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseJpaRepositoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) {
        // repository.insert(new Course(1L,"Learn AWS", "in28minutes"));
        // repository.insert(new Course(2L,"Learn Kotlin", "in28minutes"));
        // repository.insert(new Course(3L,"Learn Ktor", "in28minutes"));

        repository.save(new Course( 1L,"Learn AWS", "in28minutes"));
        repository.save(new Course( 2L,"Learn Kotlin", "in28minutes"));
        repository.save(new Course( 3L,"Learn Ktor", "in28minutes"));
        repository.findAll().forEach(System.out::println);

        System.out.println("Find by author: in28minutes");
        repository.findByAuthor("in28minutes").forEach(System.out::println);

        System.out.println("Find by author:");
        repository.findByAuthor("").forEach(System.out::println);

        System.out.println("Fint by course name:AWS");
        repository.findByNameContains("AWS").forEach(System.out::println);


        repository.deleteById(1L);

    }
}