package net.c5h8no4na.common.assertion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class AssertTest {

	@Test
	void testAssertIsFalse() {
		assertDoesNotThrow(() -> Assert.isFalse(false));
		assertThrows(() -> Assert.isFalse(true));
		assertThrows(() -> Assert.isFalse(null));
	}

	@Test
	void testAssertIsTrue() {
		assertDoesNotThrow(() -> Assert.isTrue(true));
		assertThrows(() -> Assert.isTrue(false));
		assertThrows(() -> Assert.isTrue(null));
	}

	@Test
	void testAssertIsNull() {
		assertDoesNotThrow(() -> Assert.isNull(null));
		assertThrows(() -> Assert.isNull(1));
		assertThrows(() -> Assert.isNull(""));
		assertThrows(() -> Assert.isNull(new Object()));
		assertThrows(() -> Assert.isNull(Assert.class));
		assertThrows(() -> Assert.isNull(false));
	}

	@Test
	void testAssertIsNotNull() {
		assertDoesNotThrow(() -> Assert.notNull(1));
		assertDoesNotThrow(() -> Assert.notNull(""));
		assertDoesNotThrow(() -> Assert.notNull(new Object()));
		assertDoesNotThrow(() -> Assert.notNull(Assert.class));
		assertDoesNotThrow(() -> Assert.notNull(false));
		assertThrows(() -> Assert.notNull(null));
	}

	@Test
	void testAssertNotReached() {
		assertThrows(() -> Assert.notReached());
	}

	void assertThrows(Executable e) {
		Assertions.assertThrows(AssertionError.class, e);
	}

	void assertDoesNotThrow(Executable e) {
		Assertions.assertDoesNotThrow(e);
	}

}
