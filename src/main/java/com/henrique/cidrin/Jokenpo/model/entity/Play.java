package com.henrique.cidrin.Jokenpo.model.entity;

import com.henrique.cidrin.Jokenpo.model.enums.TypeMoveEnum;
import com.henrique.cidrin.Jokenpo.model.request.PlayRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class Play {

    private String player;
    private TypeMoveEnum typeMove;

    public static Play of(PlayRequest playRequest) {
        return new Play(playRequest.getPlayer(), TypeMoveEnum.fromMove(playRequest.getTypeMove().getMove()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Play player = (Play) o;
        if (Objects.equals(this.player, player.player)) {
            player.typeMove = this.typeMove;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
