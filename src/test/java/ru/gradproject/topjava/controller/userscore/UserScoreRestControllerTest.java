package ru.gradproject.topjava.controller.userscore;

import org.junit.Test;
import org.springframework.http.MediaType;
import ru.gradproject.topjava.controller.AbstractControllerTest;
import ru.gradproject.topjava.controller.json.JsonUtil;
import ru.gradproject.topjava.model.UserScore;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Icebear on 09.07.2017.
 */
public class UserScoreRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = UserScoreRestController.REST_URL + "/";

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllByUserAndMenu() throws Exception {
        mockMvc.perform(get(REST_URL + "user/{userid}/menu/{menuid}", 100000, 100004))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllByUser() throws Exception {
        mockMvc.perform(get(REST_URL + "user/{userid}", 100000))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllByMenu() throws Exception {
        mockMvc.perform(get(REST_URL + "menu/{menuid}", 100004))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + "user/{userid}/menu/{menuid}/{id}", 100000, 100004, 100011))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testUpdate() throws Exception {
        UserScore userScore = new UserScore(100011, 15);
        mockMvc.perform(put(REST_URL + "user/{userid}/menu/{menuid}/{id}", 100000, 100004, 100011).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(userScore)))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreate() throws Exception {
        UserScore userScore = new UserScore(null, 15);
        mockMvc.perform(post(REST_URL + "user/{userid}/menu/{menuid}", 100000, 100004)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(userScore)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + "user/{userid}/menu/{menuid}/{id}", 100000, 100004, 100001)).
                andExpect(status().isOk());
    }
}