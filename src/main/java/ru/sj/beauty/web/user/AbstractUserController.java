package ru.sj.beauty.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.sj.beauty.model.User;
import ru.sj.beauty.service.UserService;
import static ru.sj.beauty.util.ValidationUtil.*;
import java.util.List;

@Controller
public abstract class AbstractUserController {
protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
   UserService service;
    User create(User user){
        log.info("create {}",user);
        checkNew(user);
return service.create(user);
    }
    User update(User user){
        log.info("update {]",user);
        assureIdConsistent(user,user.getId());
        return service.update(user);
    }


   void delete(int id){
        log.info("delete {}",id);
service.delete(id);
   }


    User get(int id){
        log.info("get {}",id);
        return  service.get(id);
    }


    User getByEmail(String email) {
    log.info("get user by email {} ",email);
return service.getByEmail(email);
    }

    List<User> getAll(){
        log.info("get ALL");
        return service.getAll();
    }
}
