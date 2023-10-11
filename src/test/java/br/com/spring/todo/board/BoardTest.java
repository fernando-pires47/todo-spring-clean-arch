package br.com.spring.todo.board;


import br.com.spring.todo.core.domain.board.builder.BoardBuilder;
import br.com.spring.todo.core.domain.board.entity.Board;
import br.com.spring.todo.core.domain.board.enumerator.BoardStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("Unit")
public class BoardTest {

    @Test
    @DisplayName("Set default create Board")
    public void setDefaultStatusBoard() {
        Board board = new BoardBuilder().create(null).build();
        Assertions.assertEquals(board.getStatus(),BoardStatus.ACTIVE);
        Assertions.assertNotNull(board.getDate_create());
    }

    @Test
    @DisplayName("Change Board status to Active")
    public void boardChangeStatusToActive() {
        Board board = new BoardBuilder().build();
        board.active();
        Assertions.assertEquals(board.getStatus(), BoardStatus.ACTIVE);
    }

    @Test
    @DisplayName("Change Board status to Inactive")
    public void boardChangeStatusToInactive() {
        Board board = new BoardBuilder().build();
        board.inactive();
        Assertions.assertEquals(board.getStatus(), BoardStatus.INACTIVE);
    }

    @Test
    @DisplayName("update Board set default update")
    public void updateBoardSetDateCreate() {
        Board board = new BoardBuilder().build();
        String name = "teste2";
        board.update(name);
        Assertions.assertEquals(board.getName(), name);
        Assertions.assertNotNull(board.getDate_update());
    }
}
