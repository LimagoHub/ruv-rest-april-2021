package de.ruv.springschulung;




public class TranslatorToLowerImpl implements Translator {

	@Override
	public String translate(String message) {
		// TODO Auto-generated method stub
		return message.toLowerCase();
	}

}
