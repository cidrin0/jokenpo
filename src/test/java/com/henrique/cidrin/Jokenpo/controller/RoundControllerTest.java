package com.henrique.cidrin.Jokenpo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique.cidrin.Jokenpo.model.entity.Play;
import com.henrique.cidrin.Jokenpo.model.entity.Round;
import com.henrique.cidrin.Jokenpo.model.enums.TypeMoveEnum;
import com.henrique.cidrin.Jokenpo.model.request.PlayRequest;
import com.henrique.cidrin.Jokenpo.service.RoundService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.TIED_ROUND;
import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.WAITING_PLAYS;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoundControllerTest {

    @Mock
    private RoundService roundService;

    @Autowired
    private ObjectMapper mapper;

    @InjectMocks
    private RoundController controller;

    private MockMvc mockMvc;

    private static final String BASE_URL = "/jokenpo/round";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGETRoundIs2xx() throws Exception {
        doReturn(new Round(1, WAITING_PLAYS)).when(roundService).getRoundActual();

        mockMvc.perform(get(BASE_URL + "/result"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.code", is(1)))
                .andExpect(jsonPath("$.result", is(WAITING_PLAYS)))
                .andExpect(jsonPath("$.players", hasSize(0)));
    }

    @Test
    public void testGETRoundByCodeIs2xx() throws Exception {
        doReturn(new Round(1, WAITING_PLAYS)).when(roundService).getRoundByCode(1);

        mockMvc.perform(get(BASE_URL + "/" + 1 + "/result"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.code", is(1)))
                .andExpect(jsonPath("$.result", is(WAITING_PLAYS)))
                .andExpect(jsonPath("$.players", hasSize(0)));
    }

    @Test
    public void testPostPlayis2xx() throws Exception {

        Set<Play> players = new HashSet<>();
        Play play1 = new Play("Jogador 1", TypeMoveEnum.TESOURA);
        players.add(play1);

        Round round = new Round(1, WAITING_PLAYS);
        round.setPlayers(players);

        doReturn(round).when(roundService).add(any());

        mockMvc.perform(post(BASE_URL)
                .contentType(APPLICATION_JSON)
                .content(mapper.writeValueAsString(new PlayRequest("Jogador 1", TypeMoveEnum.TESOURA))))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.code", is(1)))
                .andExpect(jsonPath("$.result", is(WAITING_PLAYS)))
                .andExpect(jsonPath("$.players[0].player", is(play1.getPlayer())));

    }
}