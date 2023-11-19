package com.springboot.learnjpaandhibernate.course.jpa;


import com.springboot.learnjpaandhibernate.course.Course;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {


    // @AutoWired를 사용하는 것도 좋지만 EntityManager이면 @PersistentContext를 사용하는 것도 좋다.
    @PersistenceContext
    private EntityManager entityManager;


    @PreDestroy
    public void tearDown(){
        entityManager.close();
    }

    public void insert(Course course){
        entityManager.merge( course);
    }

    public Course findById(Long id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(Long id){
        final Course course = findById(id);
        entityManager.remove(course);
    }
}
