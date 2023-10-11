package br.com.spring.todo.task;

import br.com.spring.todo.core.domain.task.enumerator.TaskStatus;
import br.com.spring.todo.usecase.task.getObject.dto.TaskGetObjectOutputDto;
import br.com.spring.todo.usecase.task.save.dto.TaskSaveInputDto;
import br.com.spring.todo.usecase.task.update.dto.TaskUpdateInputDto;
import br.com.spring.todo.uteis.UteisTest;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.ResultActions;
import java.net.URI;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskIntegrationTest {

    @Autowired
    private UteisTest uteisTest;

    @Test
    @DisplayName("Create Task")
    public void createTask() throws Exception {
        TaskSaveInputDto input = new TaskSaveInputDto("teste","teste",-99L,new Date(),new Date());
        this.uteisTest.request(HttpMethod.POST,new URI("/task/save"),input).andExpect(status().is(Response.SC_OK));
    }

    @Test
    @DisplayName("Update Task")
    public void updateTask() throws Exception {
        TaskUpdateInputDto input = new TaskUpdateInputDto(-99L,"teste","teste", new Date(),new Date());
        this.uteisTest.request(HttpMethod.PUT,new URI("/task/update"),input).andExpect(status().is(Response.SC_OK));
    }

    @Test
    @DisplayName("Get all tasks")
    public void getAllTasks() throws Exception {
        this.uteisTest.request(HttpMethod.GET,new URI("/task/all")).andExpect(status().is(Response.SC_OK));
    }

    @Test
    @DisplayName("Get specific task")
    public void getSpecificTask() throws Exception {
        this.uteisTest.request(HttpMethod.GET,new URI("/task/get/-99")).andExpect(status().is(Response.SC_OK));
    }

    @Test
    @DisplayName("Change status Task to active")
    public void changeStatusTaskToActiveTest() throws Exception {
        this.uteisTest.request(HttpMethod.PATCH,new URI("/task/active/-99")).andExpect(status().is(Response.SC_OK));
        ResultActions getResult = this.uteisTest.request(HttpMethod.GET,new URI("/task/get/-99")).andExpect(status().is(Response.SC_OK));
        TaskGetObjectOutputDto getObjectOutputDto = this.uteisTest.constructResult(TaskGetObjectOutputDto.class,getResult);
        Assertions.assertEquals(TaskStatus.ACTIVE,getObjectOutputDto.status());
    }

    @Test
    @DisplayName("Change status Task to inactive")
    public void changeStatusTaskToInactiveTest() throws Exception {
        this.uteisTest.request(HttpMethod.PATCH,new URI("/task/inactive/-98")).andExpect(status().is(Response.SC_OK));
        ResultActions getResult = this.uteisTest.request(HttpMethod.GET,new URI("/task/get/-98")).andExpect(status().is(Response.SC_OK));
        TaskGetObjectOutputDto getObjectOutputDto = this.uteisTest.constructResult(TaskGetObjectOutputDto.class,getResult);
        Assertions.assertEquals(TaskStatus.INACTIVE,getObjectOutputDto.status());
    }

    @Test
    @DisplayName("Delete task")
    public void deleteTask() throws Exception {
        this.uteisTest.request(HttpMethod.DELETE,new URI("/task/-97")).andExpect(status().is(Response.SC_OK));
        ResultActions result = this.uteisTest.request(HttpMethod.GET,new URI("/task/get/-97")).andExpect(status().is(Response.SC_NO_CONTENT));
    }
}
