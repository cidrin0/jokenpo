package com.henrique.cidrin.Jokenpo.model.response;

import com.henrique.cidrin.Jokenpo.model.entity.Play;
import com.henrique.cidrin.Jokenpo.model.entity.Round;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoundResponse {

    private Integer code;
    private Set<Play> players;
    private String result;

    public static RoundResponse of(Round round) {
        return new RoundResponse(round.getCode(), round.getPlayers(), round.getResult());
    }
}
