package de.ruv.springschulung;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Demo {
	
	public Demo() {
		System.out.println("########################## Hallo");
	}
	
	@PostConstruct
	public void run() {
		System.out.println("Ich renne...........");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Und Tschüß............");
	}

}
