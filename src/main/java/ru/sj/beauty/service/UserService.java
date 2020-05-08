package ru.sj.beauty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sj.beauty.model.User;
import ru.sj.beauty.repository.UserRepository;
import ru.sj.beauty.util.exception.NotFoundException;

import java.util.List;

import static ru.sj.beauty.util.ValidationUtil.checkNotFound;
import static  ru.sj.beauty.util.ValidationUtil.checkNotFoundWithId;
@Service
public class UserService {
    private  final UserRepository repository;
@Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public User create (User user){
 return repository.save(user);
    }

    public  User update (User user)throws NotFoundException{
    return checkNotFoundWithId(repository.save(user),user.getId());
    }

    public void delete (int id )throws NotFoundException{
    checkNotFoundWithId(repository.delete(id),id);
    }
    public User get(int id)throws NotFoundException {
    return checkNotFoundWithId(repository.get(id),id);
    }
    public User getByEmail (String email){
   return checkNotFound(repository.getByEmail(email) ,"email ="+email);
    }
    public List<User> getAll(){
   return repository.getAll();
    }


}
