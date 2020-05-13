package com.henrique.cidrin.Jokenpo.model.entity;

import com.henrique.cidrin.Jokenpo.constants.MessageConstants;
import com.henrique.cidrin.Jokenpo.model.enums.TypeResultEnum;
import com.henrique.cidrin.Jokenpo.move.Move;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.WAITING_PLAYS;
import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.WINNER_ROUND;

@Data
public class Round {

    public static final Integer MAX_PLAYS_BY_ROUND = 3;

    public Round(Integer code, String result) {
        this.players = new HashSet<>();
        this.result = result;
        this.code = code;
    }

    private Integer code;
    private Set<Play> players;
    private String result;

    public void evalue() {
        if (players.size() != MAX_PLAYS_BY_ROUND) {
            result = WAITING_PLAYS;
            return;
        }
        result = MessageConstants.TIED_ROUND;

        List<Move> moves = players.stream().map(p -> p.getTypeMove().getMove()).collect(Collectors.toList());
        players.stream().filter(p -> p.getTypeMove().getMove().evalue(moves) == TypeResultEnum.WIN).
                findAny().ifPresent(e -> result = String.format(WINNER_ROUND, e.getPlayer()));
    }
}
