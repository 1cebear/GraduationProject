package ru.gradproject.topjava.controller.dish;

import org.junit.Test;
import org.springframework.http.MediaType;
import ru.gradproject.topjava.controller.AbstractControllerTest;
import ru.gradproject.topjava.controller.json.JsonUtil;
import ru.gradproject.topjava.model.Dish;
import ru.gradproject.topjava.model.Menu;


import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Icebear on 06.07.2017.
 */
public class DishRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = DishRestController.REST_URL + "/";

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL, 100002, 100004))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + "100007", 100002, 100004))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + "100007", 100002, 100004)).
                andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        Dish dish = new Dish(100007, 50, "test update");
        mockMvc.perform(put(REST_URL +  "{id}", 100002, 100004, 100007).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(dish)))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreate() throws Exception {
        Dish dish = new Dish(null, 50, "test");
        mockMvc.perform(post(REST_URL, 100002, 100004)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(dish)))
                .andExpect(status().isCreated());
    }

}