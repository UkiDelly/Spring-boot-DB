# Spring Boot으로 JPA, Hibernate 실습하기

### 설치된 디펜던시

1. Spring Web
    
   - Rest API 서버를 만들기 위해
2. Spring Data JDBC
    
3. Spring Data JPA

4. H2 Database
    - 실습에 사용될 인메모리 데이터베이스 


---

## Jdbc

[Repository 클래스](src/main/java/com/springboot/learnjpaandhibernate/course/jdbc/CourseJdbcRepository.java)

[Jdbc Template를 실행해주는 CommandLineRunner 클래스](src/main/java/com/springboot/learnjpaandhibernate/course/jdbc/CourseJdbcCommandLineRunner.java)


### CommandLineRunner
`CommandLineRunner`는 스프링 애플리케이션이 시작할때 실행할 로직이 있을 때 사용한다.`CommandLineRunner`는 인터페이스이며, `implements`로 구현하여`run` 메서드를 호출할 수 있습니다. `run`메소드는, 애플리케이션이 시작할때 실행할 로직을 실행합니다. 

