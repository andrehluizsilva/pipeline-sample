package local.devops.service;

import local.devops.IntegrationTest;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

@Category(IntegrationTest.class)
public class DogsTest {

    static DogsClient client;

    @BeforeClass
    public static void setup() {
        client = new DogsClient();
    }

    @Test
    public void testGetDogsShouldHaveImage(){
        try {
            BufferedReader rd = client.GetDog();
            JsonObject object = Json.parse(rd).asObject();
            Dog dog = new Dog(object.get("status").asInt(), object.get("message").asString());
            assertTrue(dog.getMessage().contains(".jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
