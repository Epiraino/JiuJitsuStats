package com.ep.jiujitsustats.controllers;

import com.ep.jiujitsustats.enums.Belt;
import com.ep.jiujitsustats.models.Fighter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fighters")
public class FighterController {
    @GetMapping
    public List<Fighter> getFighters(){
        return List.of(
                new Fighter(
                        "emilio",
                        31,
                        283,
                        Belt.WHITE
                )
        );
    }
}
