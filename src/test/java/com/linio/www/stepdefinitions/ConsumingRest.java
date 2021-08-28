package com.linio.www.stepdefinitions;

import static com.linio.www.exception.IncorrectCodeResponse.MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

import com.linio.www.exception.IncorrectCodeResponse;
import com.linio.www.models.Employe;
import com.linio.www.question.CodeResponse;
import com.linio.www.task.GetService;

import com.linio.www.task.PostService;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class ConsumingRest {
	@Before
	public void before(){
		OnStage.setTheStage(Cast.ofStandardActors());
	}
	@When("^the (.*) consuming service get$")
	public void theUserConsumingServiceGet(String name) {
		OnStage.theActorCalled(name).attemptsTo(GetService.consuming("http://dummy.restapiexample.com").inResource("/api/v1/employees"));
	}


	@Then("^he should see the code response (.*)$")
	public void heShouldSeeTheCodeResponse(String code) {
	    theActorInTheSpotlight().should(seeThat(CodeResponse.theService(), is(code)).orComplainWith(IncorrectCodeResponse.class,MESSAGE));
	}

	@When("^the (.*) consuming service post with the data$")
	public void theUserConsumingServicePostWithTheData(String name, List<Employe> employes) {
		OnStage.theActorCalled(name).attemptsTo(PostService.consuming("http://dummy.restapiexample.com").inResource("/api/v1/create").andEmployed(employes.get(0)));
	}

	@When("^the (.*) consuming service get whit id (\\d+)$")
	public void theUserConsumingServiceGetWhitId(String name, int id) {
		OnStage.theActorCalled(name).attemptsTo(GetService.consuming("http://dummy.restapiexample.com").inResource("/api/v1/employee/"+id));
	}

	@When("^the (.*) consuming service get for delete whit id (\\d+)$")
	public void theUserConsumingServiceGetForDeleteWhitId(String name, int id) {
		OnStage.theActorCalled(name).attemptsTo(GetService.consuming("http://dummy.restapiexample.com").inResource("/api/v1/delete/"+id));
	}
}
