package com.linio.www.task;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetService implements Task{

	private String endPoint;
	private String resource;
	
	
	public GetService(String endPoint) {
		this.endPoint = endPoint;
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		Response response =RestAssured.given().headers("Content-Type","application/json;charset=UTF-8","Accept-Encoding","gzip,deflate").
				relaxedHTTPSValidation("TLS").when().get(endPoint+resource).then().extract().response();
		        actor.remember("response", String.valueOf(response.getStatusCode()));
		        System.out.println(response.getBody().asString());
		        Serenity.recordReportData().withTitle("Response").andContents(response.getBody().asString());
	}
	public static GetService consuming(String endPoint) {
		return Tasks.instrumented(GetService.class,endPoint);
	}
	public GetService inResource(String resource) {
		this.resource=resource;
		return this;
	}


}
