package com.henrique.cidrin.Jokenpo.service;

import com.henrique.cidrin.Jokenpo.model.entity.Play;
import com.henrique.cidrin.Jokenpo.model.entity.Round;
import com.henrique.cidrin.Jokenpo.model.enums.TypeMoveEnum;
import com.henrique.cidrin.Jokenpo.model.request.PlayRequest;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.TIED_ROUND;
import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.WAITING_PLAYS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RoundServiceTest {

    private RoundService roundService = new RoundService();

    @Test
    public void getRoundActualOneMove() {
        roundService.add(new PlayRequest("Jogador 1", TypeMoveEnum.PEDRA));

        Set<Play> plays = new HashSet<>();
        plays.add(new Play("Jogador 1", TypeMoveEnum.PEDRA));

        Round roundActual = roundService.getRoundActual();
        assertEquals(1, roundActual.getCode().intValue());
        assertEquals(WAITING_PLAYS, roundActual.getResult());
        assertArrayEquals(roundActual.getPlayers().toArray(), plays.toArray());
    }

    @Test
    public void getRoundActualTwoMoves() {
        roundService.add(new PlayRequest("Jogador 1", TypeMoveEnum.PEDRA));
        roundService.add(new PlayRequest("Jogador 2", TypeMoveEnum.PAPEL));

        Set<Play> plays = new HashSet<>();
        plays.add(new Play("Jogador 1", TypeMoveEnum.PEDRA));
        plays.add(new Play("Jogador 2", TypeMoveEnum.PAPEL));

        Round roundActual = roundService.getRoundActual();
        assertEquals(1, roundActual.getCode().intValue());
        assertEquals(WAITING_PLAYS, roundActual.getResult());
        assertArrayEquals(roundActual.getPlayers().toArray(), plays.toArray());
    }


    @Test
    public void getRoundActualThreeMoves() {
        roundService.add(new PlayRequest("Jogador 1", TypeMoveEnum.PEDRA));
        roundService.add(new PlayRequest("Jogador 2", TypeMoveEnum.PAPEL));
        roundService.add(new PlayRequest("Jogador 3", TypeMoveEnum.TESOURA));


        Set<Play> plays = new HashSet<>();
        plays.add(new Play("Jogador 1", TypeMoveEnum.PEDRA));
        plays.add(new Play("Jogador 2", TypeMoveEnum.PAPEL));
        plays.add(new Play("Jogador 3", TypeMoveEnum.TESOURA));


        Round roundActual = roundService.getRoundActual();
        assertEquals(1, roundActual.getCode().intValue());
        assertEquals(TIED_ROUND, roundActual.getResult());
        assertArrayEquals(roundActual.getPlayers().toArray(), plays.toArray());
    }
}