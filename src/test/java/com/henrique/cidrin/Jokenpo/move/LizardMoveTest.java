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

public class LizardMoveTest {

    private LizardMove lizardMove = new LizardMove();

    @Test
    public void testLizardWinPaper() {
        assertEquals(WIN, lizardMove.evalue(Collections.singletonList(new PaperMove())));
    }

    @Test
    public void testLizardWinSpock() {
        assertEquals(WIN, lizardMove.evalue(Collections.singletonList(new SpockMove())));
    }

    @Test
    public void testLizardLoseScissor() {
        assertEquals(LOSE, lizardMove.evalue(Collections.singletonList(new ScissorsMove())));
    }

    @Test
    public void testLizardLoseRock() {
        assertEquals(LOSE, lizardMove.evalue(Collections.singletonList(new RockMove())));
    }

    @Test
    public void testLizardTied() {
        assertEquals(TIE, lizardMove.evalue(Collections.singletonList(new LizardMove())));
    }
}
