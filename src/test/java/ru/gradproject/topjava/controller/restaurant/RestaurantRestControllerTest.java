package ru.gradproject.topjava.controller.restaurant;

import org.junit.Test;
import org.springframework.http.MediaType;
import ru.gradproject.topjava.controller.AbstractControllerTest;
import ru.gradproject.topjava.controller.json.JsonUtil;
import ru.gradproject.topjava.model.Restaurant;

import java.util.HashSet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Icebear on 01.07.2017.
 */
public class RestaurantRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantRestController.REST_URL+"/";

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + "100002"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


    @Test
    public void testUpdate() throws Exception {
        Restaurant restaurant = new Restaurant(100002, "test update", new HashSet<>());
        mockMvc.perform(put(REST_URL + 100002).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(restaurant)))
                .andExpect(status().isOk());

    }

    @Test
    public void testCreate() throws Exception {
        Restaurant restaurant = new Restaurant(null, "test create", new HashSet<>());

        String jsonValue = JsonUtil.writeValue(restaurant);

        mockMvc.perform(post(REST_URL, restaurant)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonValue))
                .andExpect(status().isCreated());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + "{id}", 100002)).
                andExpect(status().isOk());
    }
}