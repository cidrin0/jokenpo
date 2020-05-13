package com.henrique.cidrin.Jokenpo.move.impl;

import com.henrique.cidrin.Jokenpo.model.enums.TypeResultEnum;
import com.henrique.cidrin.Jokenpo.move.Move;

import java.io.Serializable;
import java.util.List;

public class ScissorsMove implements Move, Serializable {

    @Override
    public TypeResultEnum evalue(List<Move> move) {
        if (move.stream().anyMatch(e -> e instanceof RockMove || e instanceof SpockMove))
            return TypeResultEnum.LOSE;
        if (move.stream().allMatch(e -> e instanceof ScissorsMove))
            return TypeResultEnum.TIE;
        return TypeResultEnum.WIN;
    }
}
