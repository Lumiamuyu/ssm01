package Lumiamuyu.service;

import Lumiamuyu.pojo.User;

import java.util.List;

public interface IUserService {
    public List<User> getLists();
    public int insertOne(User user);
    public int delete(int id);
    public int update(User user);
    public User getOne(int id);
}
