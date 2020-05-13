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

public class RockMoveTest {

    private RockMove rockMove = new RockMove();

    @Test
    public void testRockWinLizard() {
        assertEquals(WIN, rockMove.evalue(Collections.singletonList(new LizardMove())));
    }

    @Test
    public void testRockWinScissor() {
        assertEquals(WIN, rockMove.evalue(Collections.singletonList(new ScissorsMove())));
    }

    @Test
    public void testRockLoseSpock() {
        assertEquals(LOSE, rockMove.evalue(Collections.singletonList(new SpockMove())));
    }

    @Test
    public void testRokcLosePaper() {
        assertEquals(LOSE, rockMove.evalue(Collections.singletonList(new PaperMove())));
    }

    @Test
    public void testRockTied() {
        assertEquals(TIE, rockMove.evalue(Collections.singletonList(new RockMove())));
    }
}
