package de.ruv.springschulung;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TranslatorConfig {
	
	
	
	@Bean
	@Qualifier("upper")
	public Translator toUpperTranslator() {
		return new TranslatorToUpperImpl();
	}

	@Bean
	@Qualifier("lower")
	public Translator toLowerTranslator() {
		return new TranslatorToLowerImpl();
	}

}
