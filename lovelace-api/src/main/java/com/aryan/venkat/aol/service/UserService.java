package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.LifeEvent;
import com.aryan.venkat.aol.entity.User;
import com.aryan.venkat.aol.model.Timeline;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long userId);

    User createUser(User user);

    User updateUser(long userId, User user);

    void addTimeLineEntries(User user);

    LifeEvent createLifeEvent(LifeEvent lifeEvent);

    Timeline generateTimeLine(User user);

    Timeline getTimeLine(long userId);
}
