package ru.sj.beauty.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sj.beauty.model.Role;
import ru.sj.beauty.model.User;
import ru.sj.beauty.service.UserService;

import java.util.Collections;
import java.util.Date;

import static ru.sj.beauty.web.user.UserTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
//@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceTest {

    @Autowired

    private UserService service;

    @Test
    public void create() throws Exception {
        User newUser = new User(1, "NewUser", "new@gmail.com", "newPass4", "89151194185", true, new Date(), Collections.singleton(Role.ROLE_USER));
        service.create(newUser);
    }
@Test
    public void update() throws Exception {
        User updated = new User(USER);
        updated.setName("UpdatedName");
        updated.setEmail("user@yandex.ru");
        service.update(updated);
        assertMatch(service.get(USER_ID), updated);
    }
}