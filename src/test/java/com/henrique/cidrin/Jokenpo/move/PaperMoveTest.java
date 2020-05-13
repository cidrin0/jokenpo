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

public class PaperMoveTest {

    private PaperMove paperMove = new PaperMove();

    @Test
    public void testPaperWinRock() {
        assertEquals(WIN, paperMove.evalue(Collections.singletonList(new RockMove())));
    }

    @Test
    public void testPaperWinSpock() {
        assertEquals(WIN, paperMove.evalue(Collections.singletonList(new SpockMove())));
    }

    @Test
    public void testPaperLoseScissor() {
        assertEquals(LOSE, paperMove.evalue(Collections.singletonList(new ScissorsMove())));
    }

    @Test
    public void testPaperLoseLizard() {
        assertEquals(LOSE, paperMove.evalue(Collections.singletonList(new LizardMove())));
    }

    @Test
    public void testPaperTied() {
        assertEquals(TIE, paperMove.evalue(Collections.singletonList(new PaperMove())));
    }
}
