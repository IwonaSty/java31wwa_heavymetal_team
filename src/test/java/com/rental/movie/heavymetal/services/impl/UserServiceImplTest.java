package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.User;
import com.rental.movie.heavymetal.services.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserServiceImplTest {

    @Autowired
    private static UserService userService;

    private static Long expectedId;
    private static User user;


    @BeforeAll
    public static void init() {
        expectedId = 1L;
        user = User.builder()
                .firstName("testname").build();
    }

    @Test
    public void userShouldBeAddedToRepository() {
        //when
        userService.save(user);
        User addUser = userService.getById(expectedId);
        //then
        assertEquals(addUser.getFirstName(), user.getFirstName());
    }

    @Test
    public void userShouldBeFindable() {
        //when
        userService.save(user);
        User addedMovie = userService.getById(expectedId);
        //then
        assertEquals(addedMovie.getFirstName(), user.getFirstName());
    }

    @Test
    public void userShouldBeUpdated() {
        //when
        String userNewName = "newName";
        userService.save(user);
        User user = userService.getById(expectedId);
        user.setFirstName(userNewName);
        userService.update(user);
        User updatedUser = userService.getById(expectedId);
        //then
        assertEquals(userNewName, updatedUser.getFirstName());

    }

    @Test
    public void userShouldBeDeleted() {
        //when
        userService.save(user);
        userService.delete(expectedId);
        //then
        User gotUser = userService.getById(expectedId);
        assertNull(gotUser);
    }

}


