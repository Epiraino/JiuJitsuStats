package com.ep.jiujitsustats;

import com.ep.jiujitsustats.dao.models.Fighter;
import com.ep.jiujitsustats.repos.FighterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JiuJitsuStatsApplicationTests {
    @Autowired
    private FighterService fighterService;
//    @Test
//    void testCreateFighter() {
//        Fighter fighter = new Fighter(
//                "emiliotest",
//                "emiliotest",
//                31,
//                281);
//
//        fighterService.createFighter(fighter);
//    }



}
