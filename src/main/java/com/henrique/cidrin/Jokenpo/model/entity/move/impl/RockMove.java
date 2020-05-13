package com.henrique.cidrin.Jokenpo.model.entity.move.impl;

import com.henrique.cidrin.Jokenpo.model.entity.move.Move;
import com.henrique.cidrin.Jokenpo.model.enums.TypeResultEnum;

import java.io.Serializable;
import java.util.List;

public class RockMove implements Move, Serializable {

    @Override
    public TypeResultEnum evalue(List<Move> move) {
        if (move.stream().anyMatch(e -> e instanceof PaperMove || e instanceof SpockMove))
            return TypeResultEnum.LOSE;
        if (move.stream().anyMatch(e -> e instanceof RockMove))
            return TypeResultEnum.TIE;
        return TypeResultEnum.WIN;
    }
}
