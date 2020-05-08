package ru.sj.beauty.web.user;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sj.beauty.model.User;
import ru.sj.beauty.service.UserService;

import static ru.sj.beauty.web.user.UserTestData.*;

@ContextConfiguration({"classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"}
)


@RunWith(SpringRunner.class)
//@Sql(scripts = "classpath:db/populateDB.sql",config = @SqlConfig(encoding = "UTF-8"))
public class AdminRestControllerTest  {
    Logger log = LoggerFactory.getLogger(getClass());

 @Autowired
    UserService service;
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @After
//    void tearDown() {
//    }
//
//    @Test
//    void testCreate() {
//    }
//
//    @Test
//    void testUpdate() {
//    }
//
//    @Test
//    void testDelete() {
//    }

    @Test
  public   void testGet() {
        log.info("test get");
        User user1 = service.get(USER_ID);
        assertMatch(user1,USER);

    }
//
//    @Test
//    void testGetByEmail() {
//    }
//
//    @Test
//    void testGetAll() {
//    }
}