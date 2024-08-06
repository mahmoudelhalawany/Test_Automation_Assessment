package com.Internship_API_Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class GetRandomCatFact {
    @Test
    public void getRandomCatFactTest () {
        Response rep_body = RestAssured.get("https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=1");
        Assert.assertEquals(rep_body.statusCode(),200);
        String factText = rep_body.jsonPath().getString("text");
        Assert.assertNotNull(factText, "The fact text is not null");
        Assert.assertFalse(factText.isEmpty(), "The fact text is empty");
        System.out.println("Random Cat Fact: "+factText);

    }
}
