package com.ep.jiujitsustats.controllers;

import com.ep.jiujitsustats.dao.models.Fighter;
import com.ep.jiujitsustats.repos.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/fighters",method = { RequestMethod.GET, RequestMethod.POST })
public class FighterController {
    private final FighterService fighterService;

    @Autowired
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }





//    @GetMapping
//    public List<Fighter> getFighter(){
//
//        return fighterService.getFighters();
//    }

    @PostMapping("/create")
    public ResponseEntity<Fighter> createFighter(@RequestBody Fighter fighter){
        return ResponseEntity.ok(fighterService.createFighter(fighter));
    }
}
