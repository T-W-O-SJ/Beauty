package ru.sj.beauty.web.user;

import org.springframework.stereotype.Controller;
import ru.sj.beauty.model.User;

import java.util.List;
@Controller
public class AdminRestController extends AbstractUserController{
    @Override
    User create(User user) {
        return super.create(user);
    }

    @Override
    User update(User user) {
        return super.update(user);
    }

    @Override
    void delete(int id) {
        super.delete(id);
    }

    @Override
    User get(int id) {
        return super.get(id);
    }

    @Override
    User getByEmail(String email) {
        return super.getByEmail(email);
    }

    @Override
    List<User> getAll() {
        return super.getAll();
    }
}
