import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import org.bson.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConnectToDB {

    public static void main(String args[]) throws IOException {

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://baonq:baonq@cluster0-9w5me.mongodb.net/?retryWrites=true");

        MongoClient mongoClient = new MongoClient(uri);
        System.out.println("Connected to the database successfully");
        // Accessing the database
        MongoDatabase database = mongoClient.getDatabase("assignment_2");
        MongoCollection<Document> colection_user = database.getCollection("user");
        //Insert User
        String ava = Utils.encodeImage(new File("ava.jpg"));
        System.out.println("dfg");
        FileOutputStream imageOutFile = new FileOutputStream(
                "ava2.jpg");
        imageOutFile.write(Utils.decodeImage(ava));
        User u = new User("hieupm", "hieupm", "Hieu", "Pham", "Lecturer", ava);
        insertUser(u, colection_user);

        System.out.println("Done");
        imageOutFile.close();
        mongoClient.close();

    }

    public static void insertUser(User u, MongoCollection<Document> collection) {
        Document document = new Document();
        document.append("user_name", u.getUser_name())
                .append("first_name", u.getFirst_name())
                .append("last_name", u.getLast_name())
                .append("password", u.getPassword())
                .append("type_id", u.getType())
                .append("avatar", u.getAvatar());
        collection.insertOne(document);
    }





}