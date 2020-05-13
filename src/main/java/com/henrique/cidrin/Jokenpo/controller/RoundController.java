package com.henrique.cidrin.Jokenpo.controller;

import com.henrique.cidrin.Jokenpo.model.entity.Round;
import com.henrique.cidrin.Jokenpo.model.request.PlayRequest;
import com.henrique.cidrin.Jokenpo.model.response.RoundResponse;
import com.henrique.cidrin.Jokenpo.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping(value = "jokenpo/round")
@Validated
public class RoundController {

    @Autowired
    private RoundService roundService;

    @PostMapping
    public ResponseEntity<RoundResponse> insertPlayed(@RequestBody @Valid PlayRequest playRequest) {
        Round round = roundService.add(playRequest);
        return ResponseEntity.ok(RoundResponse.of(round));
    }

    @GetMapping("/{code}/result")
    public ResponseEntity<RoundResponse> findRound(@PathVariable(value = "code") @Min(0) int code) {
        Round round = roundService.getRoundByCode(code);
        return ResponseEntity.ok(RoundResponse.of(round));
    }

    @GetMapping("/result")
    public ResponseEntity<RoundResponse> findRound() {
        Round round = roundService.getRoundActual();
        return ResponseEntity.ok(RoundResponse.of(round));
    }

}
