package com.apicities.citiesapi.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CountryResourceTest {

    @Test
    public void givenCountryDoesNotExists_whenCountryInfoIsRetrieved_then404IsReceived()
            throws IOException {

        // Given
        HttpUriRequest request = new HttpGet( "http://127.0.0.1:8080/countries/999" );

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test
    public void givenCountryByIDDoesExists() throws IOException, JSONException {

        JSONObject coutry = new JSONObject();
        coutry.put("id", 1);
        coutry.put("name", "Brazil");
        coutry.put("portugueseName", "Brasil");
        coutry.put("code", "BR");
        coutry.put("bacen", 1058);

        // Given
        HttpUriRequest request = new HttpGet( "http://127.0.0.1:8080/countries/1" );

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        EntityUtils.toString(httpResponse.getEntity()).equals(coutry.toString());
    }
}
