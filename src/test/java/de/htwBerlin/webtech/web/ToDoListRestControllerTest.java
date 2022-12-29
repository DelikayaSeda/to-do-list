package de.htwBerlin.webtech.web;

import de.htwBerlin.webtech.ToDoListRestController;
import de.htwBerlin.webtech.service.ToDoListService;
import de.htwBerlin.webtech.web.api.ToDoList;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ToDoListRestController.class)
public class ToDoListRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoListService toDoListService;

    @Test
    @DisplayName("should return all todos from toDoListService")
    void should_return_todo_if_it_exists() throws Exception {

        String dateFormat = "MM-dd-yyyy";
        DateFormat df = new SimpleDateFormat(dateFormat);
        Date date =  df.parse("25-12-2022");
        var todo = List.of(
                new ToDoList(1,"Web-tech","Backendtests erstellen",false, date)
        );

        // given
        doReturn(todo).when(toDoListService).findAll();

        // when
        mockMvc.perform(get("/api/v1/todolist"))

        // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].todoTitel").value("Web-tech"))
                .andExpect(jsonPath("$[0].beschreibung").value("Backendtests erstellen"))
                .andExpect(jsonPath("$[0].status").value(false))
                .andExpect(jsonPath("$[0].datum").value(date));
    }

    @Test
    @DisplayName("should return 404 if todo is not found")
    void should_return_404_if_todo_is_not_found() throws Exception {
        // given
        doReturn(null).when(toDoListService).findById(anyLong());

        // when
        mockMvc.perform(get("/api/v1/todolist/2"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a todo")
    void should_return_201_http_status_and_location_header_when_creating_a_todo() throws Exception {

        // given
        String createToDoAsJson = "{\"todoTitel\":\"Db-tech\", \"beschreibung\":\"SQL abfragen durchgehen\", \"status\":false , \"datum\":\"2202-10-22\"}";
        var todo = new ToDoList(12, null, null, false, null);
        doReturn(todo).when(toDoListService).create(any());

        // when
        mockMvc.perform(
                post("/api/v1/todolist")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(createToDoAsJson)
                )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/todolist/" + todo.getId()))));
    }

}
