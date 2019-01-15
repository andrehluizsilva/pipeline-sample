package local.devops.main;

import local.devops.model.Dog;
import local.devops.service.DogsClient;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        DogsClient client = new DogsClient();

        try {
            BufferedReader rd = client.GetDog();

            JsonObject object = Json.parse(rd).asObject();

            Dog dog = new Dog(object.get("status").asInt(), object.get("message").asString());

            System.out.println("Dog:" + dog.getMessage());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
