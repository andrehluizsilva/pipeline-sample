package local.devops.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DogsClient {

    private HttpClient client;

    private static String dogsURL = "https://dog.ceo/api/breeds/image/random";

    public DogsClient() {
        this.client = HttpClientBuilder.create().build();
    }

    public BufferedReader GetDog() throws IOException {
        HttpGet request = new HttpGet(dogsURL);
        HttpResponse response = client.execute(request);

        return new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
    }
}

