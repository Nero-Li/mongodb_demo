package com.lyming.first;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonDocument;
import org.bson.Document;

import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;


/**
 * @ClassName MongoTest
 * @Description 最基本的CRUD
 * @Author lyming
 * @Date 2020/3/20 4:11 下午
 **/
public class MongoTest {

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://192.168.2.204:27017");
        //数据库名
        MongoDatabase database = mongoClient.getDatabase("fistMongo");
        //表名
        MongoCollection<Document> collection = database.getCollection("myTestCollection");
/*        Document document = new Document()
                .append("name","lyming")
                .append("age",18);     */

        //增
/*        for (int i = 22; i < 25; i++) {

            Document document = new Document("name","lyming")
                    .append("age",i);
            collection.insertOne(document);
        }*/


        //查
/*        Block printBlock = new Block() {
            @Override
            public void apply(Object o) {
                System.out.println(o);
            }

        };
        //forEach过期了
       collection.find().forEach(printBlock);
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.cursor();
        while (cursor.hasNext()) {
//            System.out.println(cursor.next());
            System.out.println(cursor.next().get("age"));
        }*/
        //过滤查询 org.mongodb.client.model.Filters
/*        Document document = collection.find(Filters.eq("age", 19)).first();
        System.out.println(document);*/

        //改
        /*
        UpdateResult updateResult = collection.updateOne(Filters.eq("age", 19), combine(set("name", "nero")));
        long modifiedCount = updateResult.getModifiedCount();
        System.out.println(modifiedCount);
        */
        //删
        //不加过滤器的情况下,id小的先被删除
        collection.deleteOne(new BsonDocument());
    }
}
