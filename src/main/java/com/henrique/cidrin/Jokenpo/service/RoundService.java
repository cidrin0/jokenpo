package com.henrique.cidrin.Jokenpo.service;

import com.henrique.cidrin.Jokenpo.model.entity.Play;
import com.henrique.cidrin.Jokenpo.model.entity.Round;
import com.henrique.cidrin.Jokenpo.model.request.PlayRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.henrique.cidrin.Jokenpo.constants.MessageConstants.WAITING_PLAYS;
import static com.henrique.cidrin.Jokenpo.model.entity.Round.MAX_PLAYS_BY_ROUND;

@Service
public class RoundService {

    static {
        rounds = new ArrayList<>();
    }

    private static List<Round> rounds;

    public RoundService() {
        this.roundActual = new Round(1, WAITING_PLAYS);
    }

    private Round roundActual;

    public Round add(PlayRequest playRequest) {
        Round round = getRound();
        round.getPlayers().add(Play.of(playRequest));

        roundActual.evalue();
        return round;
    }

    public Round getRoundActual() {
        return roundActual;
    }

    public Round getRoundByCode(Integer code) {
        if (code.equals(roundActual.getCode()))
            return roundActual;
        return rounds.get(code);
    }

    private Round getRound() {
        if (roundActual.getPlayers().size() != MAX_PLAYS_BY_ROUND)
            return roundActual;
        rounds.add(roundActual);

        roundActual = new Round(roundActual.getCode() + 1, WAITING_PLAYS);
        return roundActual;
    }
}
