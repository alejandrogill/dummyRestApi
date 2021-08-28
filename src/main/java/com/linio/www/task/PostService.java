package com.linio.www.task;

import com.google.gson.Gson;
import com.linio.www.models.Employe;
import com.linio.www.task.builder.PostServiceBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class PostService implements Task{

	private String endPoint;
	private String resource;
	private Employe employe;

	public PostService(String endPoint, String resource, Employe employe) {
		this.endPoint = endPoint;
		this.resource = resource;
		this.employe = employe;
	}

	public PostService(String endPoint) {
		this.endPoint = endPoint;
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		Response response = RestAssured.given()
				.header("Content-type", "application/json")
				.and()
				.body(new Gson().toJson(employe))
				.when()
				.post(endPoint+resource)
				.then()
				.extract().response();
		actor.remember("response", String.valueOf(response.getStatusCode()));
		Serenity.recordReportData().withTitle("Response").andContents(response.getBody().asString());
		        System.out.println(response.getBody().asString());
	}

	public static PostServiceBuilder consuming(String endPoint) {
		return new PostServiceBuilder(endPoint);
	}

}
