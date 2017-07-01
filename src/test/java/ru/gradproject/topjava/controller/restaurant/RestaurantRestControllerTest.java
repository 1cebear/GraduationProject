package ru.gradproject.topjava.controller.restaurant;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import ru.gradproject.topjava.controller.AbstractControllerTest;
import ru.gradproject.topjava.controller.json.JsonUtil;
import ru.gradproject.topjava.model.Restaurant;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Icebear on 01.07.2017.
 */
public class RestaurantRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantRestController.REST_URL;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + "/100002"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + "/{id}", 100002)).
                andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {
        Restaurant restaurant = new Restaurant(100050, "test create");
        mockMvc.perform(post(REST_URL) .contentType(MediaType.APPLICATION_JSON).content(JsonUtil.writeValue(restaurant))).andExpect(status().isCreated());
    }

}