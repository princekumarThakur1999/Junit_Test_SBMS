package com.anoxi;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbMsJunit03RestApiApplicationTests {

	@BeforeAll
	static void beforeAll() {
		System.out.println("This method is executed only one time before all test method execution.");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("This method is executed only one time after all test method execution.");
	}

	@BeforeEach
	void setUp() {
		System.out.println("This method is executed every time before test method executed.");
	}

	@AfterEach
	void tearDown() {
		System.out.println("This method is executed every time after test method executed.");
	}

	@Test
	public void someRandomTest(){
		System.out.println("My Student Random test method");
	}

}
