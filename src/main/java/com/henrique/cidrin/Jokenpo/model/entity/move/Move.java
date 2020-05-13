package com.henrique.cidrin.Jokenpo.model.entity.move;

import com.henrique.cidrin.Jokenpo.model.enums.TypeResultEnum;

import java.util.List;

public interface Move {

    TypeResultEnum evalue(List<Move> moves);
}
