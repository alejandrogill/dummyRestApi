package com.linio.www.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodeResponse implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		
		return actor.sawAsThe("response");
	}
	
	public static CodeResponse theService() {
		return new CodeResponse();
	}

}
