package Lumiamuyu.service;

import Lumiamuyu.dao.UserDao;
import Lumiamuyu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
/*@Repository
@Component*/
@Service
/*@Controller*/
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao dao;
    @Override
    public List<User> getLists() {
        return dao.getLists();
    }

    @Override
    public int insertOne(User user) {
        return dao.insertOne(user);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public User getOne(int id) {
        return dao.getOne(id);
    }

    @Override
    public User getUser(String username) {
        return dao.getUser(username);
    }

    @Override
    public List<User> getList(User user) {
        return dao.getList(user);
    }

}
