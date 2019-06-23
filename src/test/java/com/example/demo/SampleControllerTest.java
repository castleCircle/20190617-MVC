package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.oxm.Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

	@Autowired
	MockMvc mockMvc;
	

	@Test
	public void stringMessage() throws Exception {
		this.mockMvc.perform(get("/message")
				.content("hello"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("hello"));
		
		
	}
	
	@Autowired
	ObjectMapper ObjectMapper;
	
	@Test
	public void jsonMessage() throws Exception {
		
		Person person = new Person();
		person.setName("sungwon");
		
		String jsonString = ObjectMapper.writeValueAsString(person);
		
		this.mockMvc.perform(get("/jsonMessage").contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				.content(jsonString))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("sungwon"));
	}
	
	@Autowired
	Marshaller marshaller;
	
	@Test
	public void xmlMessage() throws Exception {
		
		Person person = new Person();
		person.setName("sungwon");
		
		StringWriter stringWriter = new StringWriter();
		Result result = new StreamResult();
		marshaller.marshal(person, result);
		String xmlString = stringWriter.toString();
		
		
		this.mockMvc.perform(get("/jsonMessage")
				.contentType(MediaType.APPLICATION_XML)
				.accept(MediaType.APPLICATION_XML)
				.content(xmlString))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
}
