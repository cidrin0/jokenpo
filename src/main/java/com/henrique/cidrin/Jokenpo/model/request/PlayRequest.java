package com.henrique.cidrin.Jokenpo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.henrique.cidrin.Jokenpo.model.enums.TypeMoveEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayRequest {

    @NotBlank
    private String player;

    @NotNull
    @JsonProperty(value = "move")
    private TypeMoveEnum typeMove;
}
