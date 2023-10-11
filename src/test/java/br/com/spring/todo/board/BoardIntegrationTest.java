package br.com.spring.todo.board;

import br.com.spring.todo.usecase.board.getObject.dto.BoardGetObjectOutputDto;
import br.com.spring.todo.usecase.board.save.dto.BoardSaveInputDto;
import br.com.spring.todo.core.domain.board.enumerator.BoardStatus;
import br.com.spring.todo.usecase.board.update.dto.BoardUpdateInputDto;
import br.com.spring.todo.uteis.UteisTest;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.ResultActions;
import java.net.URI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Tag("Integration")
public class BoardIntegrationTest {

    @Autowired
    private UteisTest uteisTest;

    @Test
    @DisplayName("Create Board")
    public void createBoard() throws Exception {
        BoardSaveInputDto input = new BoardSaveInputDto("teste");
        this.uteisTest.request(HttpMethod.POST,new URI("/board/save"),input).andExpect(status().is(Response.SC_OK));
    }

    @Test
    @DisplayName("Update Board")
    public void updateBoard() throws Exception {
        BoardUpdateInputDto input = new BoardUpdateInputDto(-99L,"teste2");
        this.uteisTest.request(HttpMethod.PUT,new URI("/board/update"),input).andExpect(status().is(Response.SC_OK));
    }

    @Test
    @DisplayName("Get all boards")
    public void getAllBoards() throws Exception {
        this.uteisTest.request(HttpMethod.GET,new URI("/board/all")).andExpect(status().is(Response.SC_OK));
    }

    @Test
    @DisplayName("Get specific board")
    public void getSpecificBoard() throws Exception {
        this.uteisTest.request(HttpMethod.GET,new URI("/board/get/-99")).andExpect(status().is(Response.SC_OK));
    }

    @Test
    @DisplayName("Change status Board to active")
    public void changeStatusBoardToActiveTest() throws Exception {
        this.uteisTest.request(HttpMethod.PATCH,new URI("/board/active/-99")).andExpect(status().is(Response.SC_OK));
        ResultActions getResult = this.uteisTest.request(HttpMethod.GET,new URI("/board/get/-99")).andExpect(status().is(Response.SC_OK));
        BoardGetObjectOutputDto getObjectOutputDto = this.uteisTest.constructResult(BoardGetObjectOutputDto.class,getResult);
        assertEquals(BoardStatus.ACTIVE,getObjectOutputDto.status());
    }

    @Test
    @DisplayName("Change status Board to inactive")
    public void changeStatusBoardToInactiveTest() throws Exception {
        this.uteisTest.request(HttpMethod.PATCH,new URI("/board/inactive/-98")).andExpect(status().is(Response.SC_OK));
        ResultActions getResult = this.uteisTest.request(HttpMethod.GET,new URI("/board/get/-98")).andExpect(status().is(Response.SC_OK));
        BoardGetObjectOutputDto getObjectOutputDto = this.uteisTest.constructResult(BoardGetObjectOutputDto.class,getResult);
        assertEquals(BoardStatus.INACTIVE,getObjectOutputDto.status());
    }

    @Test
    @DisplayName("Delete Board")
    public void deleteBoard() throws Exception {
        this.uteisTest.request(HttpMethod.DELETE,new URI("/board/-97")).andExpect(status().is(Response.SC_OK));
        ResultActions result = this.uteisTest.request(HttpMethod.GET,new URI("/board/get/-97")).andExpect(status().is(Response.SC_NO_CONTENT));
    }
}
