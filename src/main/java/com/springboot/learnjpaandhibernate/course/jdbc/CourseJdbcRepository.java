package com.springboot.learnjpaandhibernate.course.jdbc;

import com.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    // Spring Jdbc Template
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void createTable(){
        springJdbcTemplate.execute("""
                create table if not exists course
                (
                    id bigint not null,
                    name varchar(255) not null,
                    author varchar(255) not null,

                    primary key (id)
                );""");
    }

    public void insertData(Course course){
        String sql = "insert into course(id,name,author)values ( ?,?,? )";
        springJdbcTemplate.update(sql, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteData(Long id){
        String sql = "delete from course where id = ?";
        springJdbcTemplate.update(sql, id);
    }
}
