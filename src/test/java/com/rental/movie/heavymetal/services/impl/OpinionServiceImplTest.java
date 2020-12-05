package com.rental.movie.heavymetal.services.impl;

import com.rental.movie.heavymetal.model.opinion.Opinion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class OpinionServiceImplTest {
    @Autowired
    private OpinionServiceImpl opinionService;

    private static Long expectedId;
    private static Opinion opinion;


    @BeforeAll
    public static void init() {
        expectedId = 1L;
        opinion = new Opinion();
        opinion.setUserComment("comment");
    }

    @Test
    public void opinionShouldBeAddedToRepository(){
        //when
        opinionService.save(opinion);
        Opinion addedOpinion = opinionService.getById(expectedId);
        //then
        assertEquals(addedOpinion.getUserComment(), opinion.getUserComment());
    }

    @Test
    public void opinionShouldBeFindable(){
        //when
        opinionService.save(opinion);
        Opinion addedOpinion = opinionService.getById(expectedId);
        //then
        assertEquals(addedOpinion.getUserComment(), opinion.getUserComment());
    }

    @Test
    public void opinionShouldBeUpdated(){
        //when
        String updatedComment = "Update title";
        opinionService.save(opinion);
        Opinion opinion = opinionService.getById(expectedId);
        opinion.setUserComment(updatedComment);
        opinionService.update(opinion);
        Opinion updatedOpinion = opinionService.getById(expectedId);
        //then
        assertEquals(updatedOpinion.getId(), opinion.getId());
        assertEquals(updatedComment, updatedOpinion.getUserComment());

    }

    @Test
    public void opinionShouldBeDeleted(){
        //when
        opinionService.save(opinion);
        opinionService.delete(expectedId);
        //then
        Opinion opinion = opinionService.getById(expectedId);
        assertNull(opinion);
    }




}