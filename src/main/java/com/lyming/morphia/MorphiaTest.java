package com.lyming.morphia;

import com.lyming.entity.Member;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

/**
 * @ClassName MorphiaTest
 * @Description Morphia ODM 不是重点,Mongo Template 才是重点
 * @Author lyming
 * @Date 2020/3/20 11:00 下午
 **/
public class MorphiaTest {

    public static void main(String[] args) {
        final Morphia morphia = new Morphia();
        morphia.mapPackage("com.lyming.entity");
        Datastore datastore = morphia.createDatastore(new MongoClient("192.168.2.204", 27017), "morphia");

        /**增*/
/*       Member member ;
        for (int i = 18; i < 20; i++) {
            member = new Member();
            member.setName("lyming"+(i-16));
            member.setAge(i+1);
            member.setAddr("Hubei Wuhan");
            datastore.save(member);
            member = null;
        }*/


//        System.out.println(memberKey.getId()+":::"+memberKey.getType()+":::"+memberKey.getCollection());

        /**查*/
        //Get()
//        Member member = datastore.get(Member.class, new ObjectId("5e75b13f2051b63cf4aae108"));
//        System.out.println(member);
        //循环中使用
/*        for (Member member : datastore.find(Member.class, "age >", 25)) {
            System.out.println(member);
        }*/
 /*       Query<Member> members = datastore.createQuery(Member.class).filter("age >", 25);
        for (Member member : members) {
            System.out.println(member);
        }*/
        //结果排序
/*        Query<Member> members = datastore.createQuery(Member.class).filter("age >", 25).order("age").limit(5);
        for (Member member : members) {
            System.out.println(member);
        }*/

        /**删*/
        //根据id删
//        datastore.delete(Member.class, new ObjectId("5e75b13f2051b63cf4aae107"));
        //条件删
//        datastore.delete(datastore.createQuery(Member.class).filter("age >=", 29));

        /**改*/
        //根据条件删
        Query<Member> query = datastore.createQuery(Member.class).filter("age <", 25);
        UpdateOperations<Member> updateOperations = datastore.createUpdateOperations(Member.class).set("age", 99);
        datastore.update(query, updateOperations);
    }
}
