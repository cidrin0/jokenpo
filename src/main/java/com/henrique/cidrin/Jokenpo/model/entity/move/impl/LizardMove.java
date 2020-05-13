package com.henrique.cidrin.Jokenpo.model.entity.move.impl;

import com.henrique.cidrin.Jokenpo.model.entity.move.Move;
import com.henrique.cidrin.Jokenpo.model.enums.TypeResultEnum;

import java.io.Serializable;
import java.util.List;

public class LizardMove implements Move, Serializable {

    @Override
    public TypeResultEnum evalue(List<Move> move) {
        if (move.stream().anyMatch(e -> e instanceof ScissorsMove || e instanceof RockMove))
            return TypeResultEnum.LOSE;
        if (move.stream().allMatch(e -> e instanceof LizardMove))
            return TypeResultEnum.TIE;
        return TypeResultEnum.WIN;
    }
}
