package com.ep.jiujitsustats.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshalling;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.ep.jiujitsustats.enums.Belt;

import java.util.Objects;
import java.util.UUID;

@DynamoDBTable(tableName = "Fighters")
public class Fighter {

    private String userId;
    private String name;
    private int age;
    private int weight;
    private Belt belt;
    private int wins;
    private int losses;


    public Fighter(String name, int age, int weight, Belt belt) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.belt = belt;
    }
    @DynamoDBHashKey(attributeName = "UserId")
    public String getUserId() {
        return userId;
    }




@DynamoDBHashKey(attributeName = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Belt getBelt() {
        return belt;
    }

    public void setBelt(Belt belt) {
        this.belt = belt;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wins=" + wins +
                ", losses=" + losses +
                ", weight=" + weight +
                ", belt=" + belt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fighter fighter = (Fighter) o;
        return age == fighter.age && wins == fighter.wins && losses == fighter.losses && weight == fighter.weight && Objects.equals(name, fighter.name) && belt == fighter.belt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, wins, losses, weight, belt);
    }
}