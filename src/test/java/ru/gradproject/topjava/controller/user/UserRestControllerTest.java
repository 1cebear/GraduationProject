package ru.gradproject.topjava.controller.user;

import org.junit.Test;
import org.springframework.http.MediaType;
import ru.gradproject.topjava.controller.AbstractControllerTest;
import ru.gradproject.topjava.controller.json.JsonUtil;
import ru.gradproject.topjava.model.User;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Icebear on 08.07.2017.
 */
public class UserRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = UserRestController.REST_URL + "/";

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + "100000"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + "{id}", 100000)).
                andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User(100000, "test update");
        mockMvc.perform(put(REST_URL + 100000).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(user)))
                .andExpect(status().isOk());

    }

    @Test
    public void testCreate() throws Exception {
        User user = new User(null, "test create");

        String jsonValue = JsonUtil.writeValue(user);

        mockMvc.perform(post(REST_URL, user)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonValue))
                .andExpect(status().isCreated());
    }

}