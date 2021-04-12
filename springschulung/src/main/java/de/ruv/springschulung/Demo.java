package de.ruv.springschulung;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Controller
//@Scope("prototype")
public class Demo {
	
	
	private final Translator translator;
	

	public Demo(final @Qualifier ("upper") Translator translator) {
		this.translator = translator;
		System.out.println(translator.translate("########################## Hallo"));
	}
	
	@PostConstruct
	public void run() {
		System.out.println(translator.translate("Ich renne..........."));
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Und Tschüß............");
	}

}
