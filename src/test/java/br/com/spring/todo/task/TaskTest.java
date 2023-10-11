package br.com.spring.todo.task;


import br.com.spring.todo.core.domain.board.builder.BoardBuilder;
import br.com.spring.todo.core.domain.task.builder.TaskBuilder;
import br.com.spring.todo.core.domain.task.entity.Task;
import br.com.spring.todo.core.domain.task.enumerator.TaskStatus;
import br.com.spring.todo.infra.domain.board.model.BoardModelMockImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskTest {

    @Test
    @DisplayName("Set default create Task")
    public void setDefaultStatusTask() {
        Task task = new TaskBuilder().create(null,null,null,null,null).build();
        Assertions.assertEquals(task.getStatus(), TaskStatus.ACTIVE);
        Assertions.assertNotNull(task.getDate_create());
    }

    @Test
    @DisplayName("Change Task status to Active")
    public void taskChangeStatusToActive() {
        Task task = new TaskBuilder().build();
        task.active();
        Assertions.assertEquals(task.getStatus(), TaskStatus.ACTIVE);
    }

    @Test
    @DisplayName("Change Task status to Inactive")
    public void taskChangeStatusToInactive() {
        Task task = new TaskBuilder().build();
        task.inactive();
        Assertions.assertEquals(task.getStatus(), TaskStatus.INACTIVE);
    }

    @Test
    @DisplayName("Change Task board")
    public void taskChangeBoard()  {
        Task task = new TaskBuilder().build();
        Long idBoard2 = -98L;
        task.changeBoard(new BoardBuilder().set(new BoardModelMockImpl(idBoard2, null, null, null, null)).build());
        Assertions.assertEquals(task.getBoard().getId(), idBoard2);
    }

    @Test
    @DisplayName("update Task set default update")
    public void updateTaskSetDateCreate() {
        Task task = new TaskBuilder().build();
        String title = "teste2";
        String description = "desc2";
        Date date_start = new Date();
        Date date_end = new Date();
        task.update(title,description,date_start,date_end);
        Assertions.assertEquals(task.getTitle(),title);
        Assertions.assertEquals(task.getDescription(),description);
        Assertions.assertEquals(task.getDate_start(),date_start);
        Assertions.assertEquals(task.getDate_end(),date_end);
    }
}
