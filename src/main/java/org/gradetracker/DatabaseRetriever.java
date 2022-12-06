package org.gradetracker;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.*;

public class DatabaseRetriever {

    public static MongoDatabase gradeDb;
    public static MongoCollection<Document> gradeCol;

    public DatabaseRetriever(){
        MongoClient client = MongoClients.create(CLIENT_ID);
        gradeDb = client.getDatabase("gradeTrackerDB");
        gradeCol = gradeDb.getCollection("subjectCol");
    }

    public void addSubject(List<String> DataFieldText) {

        gradeCol.insertOne(new Document()
                .append("SUBJECT", DataFieldText.get(0).toUpperCase().strip())
                .append("TEACHER", DataFieldText.get(1).toUpperCase().strip())
                .append("IMPORTANCE", DataFieldText.get(2).toUpperCase().strip() + "/10")
        );


    }

    public List<List<String>> readSubject() {



        List<List<String>> classList = new ArrayList<>();

        FindIterable<Document> iterDoc = gradeCol.find();

        for (Document document : iterDoc) {

            classList.add(Arrays.asList((String) document.get("SUBJECT"), (String) document.get("TEACHER"), (String) document.get("IMPORTANCE")));

        }

        return classList;


    }

    public void removeSubject(String subjectName){
        gradeCol.deleteOne(Filters.eq("SUBJECT",subjectName));
    }


}
