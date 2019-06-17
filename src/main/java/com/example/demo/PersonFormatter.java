package com.example.demo;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class PersonFormatter implements Formatter<Person>{

	@Override
	public String print(Person object, Locale locale) {
		return object.toString();
	}

	@Override
	public Person parse(String text, Locale locale) throws ParseException {
		Person person = new Person();
		person.setName(text);
		return person;
	}

}
