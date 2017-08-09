package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData=new ModelData();

    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        List<User> u = new ArrayList<User>();
        User user1 = new User("User1", 1, 24);
        User user2 = new User("User2", 2, 27);
        User user3 = new User("User3", 3, 7);
        User user4 = new User("User4", 4, 14);
        u.add(user1);
        u.add(user2);
        u.add(user3);
        u.add(user4);

        modelData.setUsers(u);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

}
