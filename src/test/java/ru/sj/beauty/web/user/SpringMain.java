package ru.sj.beauty.web.user;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.sj.beauty.model.Role;
import ru.sj.beauty.model.User;

import java.util.Arrays;


import static ru.sj.beauty.web.user.UserTestData.ADMIN_ID;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml", "spring/spring-db.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            adminUserController.create(new User(null, "Admin1","89151194288","admina@gmail.com", "admin4666", Role.ROLE_ADMIN))
            ;adminUserController.c
            System.out.println();


        }
    }
}
