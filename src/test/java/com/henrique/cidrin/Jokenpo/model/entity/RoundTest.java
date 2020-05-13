package com.henrique.cidrin.Jokenpo.model.entity;

import org.junit.Test;

import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.TIED_ROUND;
import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.WAITING_PLAYS;
import static com.henrique.cidrin.Jokenpo.model.enums.TypeMoveEnum.PAPEL;
import static com.henrique.cidrin.Jokenpo.model.enums.TypeMoveEnum.PEDRA;
import static com.henrique.cidrin.Jokenpo.model.enums.TypeMoveEnum.TESOURA;
import static org.junit.Assert.assertEquals;

public class RoundTest {

    private Round round;

    @Test
    public void testRoundWin() {
        initRound(new Play("Jogador 1", TESOURA),
                new Play("Jogador 2", PAPEL),
                new Play("Jogador 3", PAPEL));

        round.evalue();
        assertEquals(" O Jogador 1 venceu", round.getResult());
    }

    @Test
    public void testRoundTied() {
        initRound(new Play("Jogador 1", TESOURA),
                new Play("Jogador 2", PAPEL),
                new Play("Jogador 3", PEDRA));

        round.evalue();
        assertEquals(TIED_ROUND, round.getResult());
    }

    private void initRound(Play... plays) {
        round = new Round(1, WAITING_PLAYS);
        for (Play play : plays)
            round.getPlayers().add(play);
    }
}
