package br.com.spring.todo.uteis;

import br.com.spring.todo.infra.configuration.security.SecurityEnvironment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Service
public class UteisTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SecurityEnvironment securityEnvironment;

    public <T> T constructResult(Class<T> clazz, ResultActions resultActions) throws UnsupportedEncodingException, JsonProcessingException {
        String valueRet = resultActions.andReturn().getResponse().getContentAsString();
        return new ObjectMapper().readValue(valueRet, clazz);
    }

    public ResultActions request(HttpMethod httpMethod,URI uri) throws Exception {
        return this.request(httpMethod,uri,null);
    }

    public ResultActions request(HttpMethod httpMethod,URI uri, Object value) throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
                .request(httpMethod,uri)
                .header(securityEnvironment.getAuthTokenKey(), securityEnvironment.getAuthTokenValue())
                .contentType(MediaType.APPLICATION_JSON);

        if(value != null){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()));
            mockHttpServletRequestBuilder.content(objectMapper.writeValueAsString(value));
        }

        return mockMvc.perform(
            mockHttpServletRequestBuilder
        );
    }
}
