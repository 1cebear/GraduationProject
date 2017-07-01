package ru.gradproject.topjava.controller.menu;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import ru.gradproject.topjava.controller.AbstractControllerTest;
import ru.gradproject.topjava.controller.json.JsonUtil;
import ru.gradproject.topjava.model.Menu;
import ru.gradproject.topjava.model.Restaurant;


import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Icebear on 27.06.2017.
 */
public class MenuRestControllerTest extends AbstractControllerTest{



    private static final String REST_URL = MenuRestController.REST_URL;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL , 100002))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL +"/{id}", 100002, 100004))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL +"/{id}", 100002, 100004)).
                andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        Menu updated = new Menu();
        updated.setName("test update");
        mockMvc.perform(put(REST_URL + "/{id}", 100002, 100004)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated))).andExpect(status().isOk());
    }

    @Test
    public void testCreate() throws Exception
    {

        Menu created = new Menu(100050, "test create", new Restaurant(), LocalDateTime.now());
        ResultActions action =  mockMvc.perform(post(REST_URL, 100002)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created))).andExpect(status().isCreated());
    }

}