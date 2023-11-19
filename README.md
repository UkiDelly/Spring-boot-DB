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

---

## JPA

JPA를 사용하기 위해선 몇가지 설정이 필요하다.
```java
@Entity // name 속성을 이용하여 테이블명을 변경할 수 있다.
public class Course {

    @Id // primary Key로 지졍함을 의미한다.
    private Long id;

    // 테이블명과 같으므로, @Column 어노테이션이 필요 없음
    private String name;
    private String author;

    public Course() {
    }
    public Course(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
```

JPA를 사용하기 위해선 먼저 Entity 설정을 해야한다. 엔티티로 사용할 클래스에 `@Entity` 어노테이셔을 추가한다. 이때 테이블명은 클래명을 따라가게 되므로, 클래스명과 테이블명을 분리하고 싶을때는 `name` 속성에 원하는 테이블명을 추가하면 된다.

그런 다음에 `Repository`로 사용할 클래스를 생성한다.

```java
@Repository // Respository임을 나타내는 스테레오 타입의 Bean
@Transactional // Transaction 추가
public class CourseJpaRepository {


    // @AutoWired를 사용하는 것도 좋지만 EntityManager이면 @PersistentContext를 사용하는 것도 좋다.
    @PersistenceContext
    private EntityManager entityManager;


    @PreDestroy
    public void tearDown(){
        entityManager.close();
    }

    public void insert(Course course){
        entityManager.merge(course);
    }

    public Course findById(Long id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);
    }
}
```

`Repository`로 사용할 클래스를 지정하고 `@Repository`어노테이션과 트랜잭션 사용을 위해 `@Transaction`어노테이션을 추가한다. 

JPA는 `EntityManager`를 통해 엔티티를 관리하고, 쿼리를 실행시킬수 있다. `@Autowired`를 사용하여 자동연결을 해줘도 되지만, EntityManager이라면 `@PersistenceContext` 어노테이션을 사용하여 자동 연결하는게 더 좋다.

---

## Hibernate vs JPA vs Spring Data JPA

### JPA

`JPA`는 API 명세서이다. 단순 명세서이기 때문에 대부분 어노테이션과 인터페이스만 존재한다.

### Hibernate

`Hibernate`는 `JPA`의 구현체이다. 즉, `JPA`에서 제공하는 각종 어노테이션과 인터페이스를 `class`로 구현한 구현체인것이다.

즉, `JPA`는 구현체가 아닌 명세서(인터페이스)이기 때문에, 구현체로 굳이 `Hibernate`를 사용할 필요는 없다. 원하는 다른 구현체를 사용할수 있다.

### Spring Data JPA

`Spring Data JPA`는 JPA를 편리하게 사용하기 위해 만든 스프링 모듈이다. 즉, JPA를 사용할때 EntityManager를 사용해야하는데, Spring Data JPA를 사용하면 EntityManager 조차도 사용할 필요 없다. 