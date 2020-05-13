package com.henrique.cidrin.Jokenpo.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.henrique.cidrin.Jokenpo.model.entity.move.Move;
import com.henrique.cidrin.Jokenpo.model.entity.move.impl.LizardMove;
import com.henrique.cidrin.Jokenpo.model.entity.move.impl.PaperMove;
import com.henrique.cidrin.Jokenpo.model.entity.move.impl.RockMove;
import com.henrique.cidrin.Jokenpo.model.entity.move.impl.ScissorsMove;
import com.henrique.cidrin.Jokenpo.model.entity.move.impl.SpockMove;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.MOVIMENT_INVALID;

@AllArgsConstructor
public enum TypeMoveEnum {

    TESOURA(new ScissorsMove()),
    PEDRA(new RockMove()),
    PAPEL(new PaperMove()),
    SPOCK(new SpockMove()),
    LAGARTO(new LizardMove());

    @Getter
    private Move move;

    @JsonValue
    public String value() {
        return this.name();
    }

    @JsonCreator
    public static TypeMoveEnum fromValue(String value) {
        return Arrays.stream(TypeMoveEnum.values()).filter(e -> e.name().equals(value)).findAny().
                orElseThrow(() -> new RuntimeException(String.format(MOVIMENT_INVALID, value)));
    }

    public static TypeMoveEnum fromMove(Move move) {
        return Arrays.stream(TypeMoveEnum.values()).
                filter(e -> e.move.getClass().isAssignableFrom(move.getClass())).findAny().
                orElseThrow(() -> new RuntimeException(String.format(MOVIMENT_INVALID, move.getClass().getName())));
    }

}
