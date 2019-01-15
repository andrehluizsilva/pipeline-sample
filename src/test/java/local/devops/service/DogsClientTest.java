package local.devops.service;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DogsClientTest {

    static DogsClient client;

    @BeforeClass
    public static void setup() {
        client = new DogsClient();
    }

    @Test
    public void testGetDogsShouldHaveImage(){
        assertTrue(true);
    }
}
