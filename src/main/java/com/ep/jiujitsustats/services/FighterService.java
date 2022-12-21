package com.ep.jiujitsustats.services;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.ep.jiujitsustats.enums.Belt;
import com.ep.jiujitsustats.models.Fighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FighterService {
    private final DynamoDBMapper dynamoDBMapper;
    @Autowired
    public FighterService(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

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
