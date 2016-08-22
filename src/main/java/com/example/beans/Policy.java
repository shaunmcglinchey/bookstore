package com.example.beans;

import com.example.configuration.ObjectID_Serializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.bson.types.ObjectId;

public class Policy {

    private ObjectId id;
    private ObjectId customerId;
    private String name;


    public Policy() {}

    public Policy(String name, String customer) {
        this.setId(new ObjectId());
        this.setCustomerId(new ObjectId(customer));
        this.name = name;
    }

    @JsonSerialize(using=ObjectID_Serializer.class)
    public ObjectId getId() {
        if(id == null){
            return id = new ObjectId();
        }
        return id;
    }

    @JsonSerialize(using=ObjectID_Serializer.class)
    public void setId(ObjectId id) {
        this.id = id;
    }

    @JsonSerialize(using=ObjectID_Serializer.class)
    public ObjectId getCustomerId() {
        if(customerId == null){
            return customerId = new ObjectId();
        }
        return customerId;
    }

    @JsonSerialize(using=ObjectID_Serializer.class)
    public void setCustomerId(ObjectId customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Policy[id=%s, name='%s', customerId=%s]",
                id, name, customerId);
    }
}

