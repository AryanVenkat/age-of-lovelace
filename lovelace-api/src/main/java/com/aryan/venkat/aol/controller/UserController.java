package com.aryan.venkat.aol.controller;

import com.aryan.venkat.aol.entity.LifeEvent;
import com.aryan.venkat.aol.entity.User;
import com.aryan.venkat.aol.model.Timeline;
import com.aryan.venkat.aol.service.TimelineEntryService;
import com.aryan.venkat.aol.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TimelineEntryService timelineEntryService;

    // GET - Get all users
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET - Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    // POST - Create a new user
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // PUT - Update user by ID
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        return  ResponseEntity.ok().body(updatedUser);
    }

    @PostMapping("/lifeEvents")
    public ResponseEntity<List<LifeEvent>> createLifeEvents(@RequestBody List<LifeEvent> lifeEvents) {
        if(CollectionUtils.isEmpty(lifeEvents)) {
            throw new IllegalArgumentException("LifeEvent cannot be empty");
        }
        List<LifeEvent> createdLifeEvents = new ArrayList<>();
        lifeEvents.forEach(lifeEvent -> {
            LifeEvent createdLifeEvent = userService.createLifeEvent(lifeEvent);
            createdLifeEvents.add(createdLifeEvent);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(createdLifeEvents);
    }

    @PostMapping("/timeline")
    public ResponseEntity<Timeline> generateTimeline(@RequestBody User user) {
        Timeline timeline = userService.generateTimeLine(user);
        return ResponseEntity.ok().body(timeline);
    }

    @GetMapping("/{userId}/timeline")
    public ResponseEntity<Timeline> getUserTimeline(@PathVariable Long userId) {

        Timeline timeline = userService.getTimeLine(userId);

        return ResponseEntity.ok().body(timeline);
    }
}
