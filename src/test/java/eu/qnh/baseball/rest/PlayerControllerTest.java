package eu.qnh.baseball.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.qnh.baseball.model.Player;
import eu.qnh.baseball.service.PlayerService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;


    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.playerController).build();
    }

    @Test
    public void addPlayerTest() throws Exception {

        Player player = new Player(3L);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(player);

        Mockito.when(this.playerService.save(any(Player.class))).thenReturn(player);

        this.mockMvc.perform(post("/api/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(jsonPath("$.id", is(Long.valueOf(player.getId()).intValue())))
                .andExpect(jsonPath("$.name", is(player.getName())))
//                .andExpect(jsonPath("$.mixed", is(sport.isMixed())))
                .andExpect(status().isCreated()
                );
    }
}
