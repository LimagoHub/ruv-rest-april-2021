package de.ruv.springschulung;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Component
//@Scope("prototype")
public class Demo {
	
	//@Value("${Demo.wagner}")
	private String message = "########################## Hallo";
	
	
	//@Autowired
	private final Translator translator;
	
	//@Autowired
	public Demo(final @Qualifier ("upper") Translator translator) {
		this.translator = translator;
		System.out.println(translator.translate(message));
	}
	
	@PostConstruct
	public void run() {
		System.out.println(translator.translate(message));
		System.out.println(translator.translate("Ich renne..........."));
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Und Tschüß............");
	}

}
