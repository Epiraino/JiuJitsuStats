package com.ep.jiujitsustats.controllers;

import com.ep.jiujitsustats.enums.Belt;
import com.ep.jiujitsustats.models.Fighter;
import com.ep.jiujitsustats.services.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fighters")
public class FighterController {
    private final FighterService fighterService;

    @Autowired
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping
    public List<Fighter> getFighters(){
        return fighterService.getFighters();
    }
}
