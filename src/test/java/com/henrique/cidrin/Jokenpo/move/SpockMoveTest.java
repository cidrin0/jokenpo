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

public class SpockMoveTest {

    private SpockMove spockMove = new SpockMove();

    @Test
    public void testSpockWinRock() {
        assertEquals(WIN, spockMove.evalue(Collections.singletonList(new RockMove())));
    }

    @Test
    public void testSpockWinScissor() {
        assertEquals(WIN, spockMove.evalue(Collections.singletonList(new ScissorsMove())));
    }

    @Test
    public void testScissorLosePaper() {
        assertEquals(LOSE, spockMove.evalue(Collections.singletonList(new PaperMove())));
    }

    @Test
    public void testScissorLoseLizard() {
        assertEquals(LOSE, spockMove.evalue(Collections.singletonList(new LizardMove())));
    }

    @Test
    public void testSpockTied() {
        assertEquals(TIE, spockMove.evalue(Collections.singletonList(new SpockMove())));
    }
}
