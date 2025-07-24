package com.anoxi;

import com.anoxi.service.MessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbmsJunit01ApplicationTests {

	@Autowired
	private MessageService messageService;

	@Test
	public void testWelcomeMsg() {

		//called target method
		String welcomeMsg = messageService.welcomeMsg();

		//validate the result
		Assertions.assertEquals("Welcome to Anoxi appilcation...!!!", welcomeMsg);
	}

	@Test
	public void testGreetMsg() {

		//called target method
		String greetMsg = messageService.greetMsg();

		//validate the result
		Assertions.assertEquals("""
                        Good Morning,
                        Have a Nice Day....!!!!
                        With Lovely Good Friday.
                      """
				, greetMsg);
	}
	@Test
	public void testWish01(){

		//called target method
		String rajuwish = messageService.wish("Raju");

		//validate the result
		Assertions.assertEquals("Hey Raju, How are you ?", rajuwish);
	}
	@Test
	public void testWish02(){

		//called target method
		String hirawish = messageService.wish("hira");

		//validate the result
		Assertions.assertEquals("Hey Hira, How are you ?", hirawish);
	}
	@Test
	public void testWish03(){

		//called target method
		String nullExpect = messageService.wish("john");

		//validate the result
		Assertions.assertEquals(null, nullExpect);
	}
}
