package com.henrique.cidrin.Jokenpo.move;

import com.henrique.cidrin.Jokenpo.move.impl.LizardMove;
import com.henrique.cidrin.Jokenpo.move.impl.PaperMove;
import com.henrique.cidrin.Jokenpo.move.impl.RockMove;
import com.henrique.cidrin.Jokenpo.move.impl.ScissorsMove;
import com.henrique.cidrin.Jokenpo.move.impl.SpockMove;
import org.junit.Test;

import java.util.Collections;

import static com.henrique.cidrin.Jokenpo.model.enums.TypeResultEnum.LOSE;
import static com.henrique.cidrin.Jokenpo.model.enums.TypeResultEnum.TIE;
import static com.henrique.cidrin.Jokenpo.model.enums.TypeResultEnum.WIN;
import static org.junit.Assert.assertEquals;

public class ScissorMoveTest {

    private ScissorsMove scissorsMove = new ScissorsMove();

    @Test
    public void testScissorWinPaper() {
        assertEquals(WIN, scissorsMove.evalue(Collections.singletonList(new PaperMove())));
    }

    @Test
    public void testScissorWinLizard() {
        assertEquals(WIN, scissorsMove.evalue(Collections.singletonList(new LizardMove())));
    }

    @Test
    public void testScissorLoseSpock() {
        assertEquals(LOSE, scissorsMove.evalue(Collections.singletonList(new SpockMove())));
    }

    @Test
    public void testScissorLoseRock() {
        assertEquals(LOSE, scissorsMove.evalue(Collections.singletonList(new RockMove())));
    }

    @Test
    public void testScissorTied() {
        assertEquals(TIE, scissorsMove.evalue(Collections.singletonList(new ScissorsMove())));
    }
}
