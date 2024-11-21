package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	private static Stream<Arguments> argumentsForAddPositive() {
		
		return Stream.of(
				arguments(2, 5, 7, false),
				arguments(-1, 4, 3, true),
				arguments(0, 1, 1, true),
				arguments(5, 6, 11, false), 
				arguments(1, 12, 13, false),
				arguments(-2, 2, 0, true));
	}			
	
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(12,28)).isEqualTo(40);
		assertThat(testDemo.addPositive(5,15)).isEqualTo(20);
			
	}
	
	@Test
	public void testTheNumberIsEven_EvenNumber() {
		TestDemo testDemo = new TestDemo (); 
		int evenNumber = 10;
		assertTrue(testDemo.theNumberIsEven(evenNumber));
	}
	
	@Test
	public void testTheNumberISEven_OddNumber() {
		TestDemo testDemo = new TestDemo();
		int oddNumber = 11;
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			testDemo.theNumberIsEven(oddNumber);
		});
		
		assertEquals("That number is not even.", exception.getMessage());
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
	
	
	

}
