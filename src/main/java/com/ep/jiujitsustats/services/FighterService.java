package com.ep.jiujitsustats.services;

import com.ep.jiujitsustats.enums.Belt;
import com.ep.jiujitsustats.models.Fighter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FighterService {
//    private final DynamoDBMapper dynamoDBMapper;

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
