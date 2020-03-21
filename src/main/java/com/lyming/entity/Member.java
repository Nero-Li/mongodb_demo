package com.lyming.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * @ClassName Member
 * @Description TODO
 * @Author lyming
 * @Date 2020/3/21 10:18 上午
 **/
@Data
@Entity
public class Member {

    @Id
    private ObjectId id;

    private String name;

    private int age;

    private String addr;
}
