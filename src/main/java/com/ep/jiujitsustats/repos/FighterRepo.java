package com.ep.jiujitsustats.repos;

import com.ep.jiujitsustats.dao.models.Fighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

@Repository
public class FighterRepo {
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public FighterRepo(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
    }

    public void save(final Fighter fighter) {
        DynamoDbTable<Fighter> orderTable = getTable();
        orderTable.putItem(fighter);
    }
    private DynamoDbTable<Fighter> getTable() {
        // Create a tablescheme to scan our bean class order
        DynamoDbTable<Fighter> orderTable =
                dynamoDbEnhancedClient.table("Fighters",
                        TableSchema.fromBean(Fighter.class));
        return orderTable;
    }
}
