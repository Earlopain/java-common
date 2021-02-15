package net.c5h8no4na.common.assertion;

public class Assert {

	private Assert() {}

	public static void isTrue(Boolean value, String message) {
		if (!Boolean.TRUE.equals(value)) {
			throw new AssertionError(message);
		}
	}

	public static void isTrue(Boolean value) {
		isTrue(value, String.format("%b passed, was expected to be true", value));
	}

	public static void isFalse(Boolean value, String message) {
		if (!Boolean.FALSE.equals(value)) {
			throw new AssertionError(message);
		}
	}

	public static void isFalse(Boolean value) {
		isFalse(value, String.format("%b was passed, was expected to be false", value));
	}

	public static void notNull(Object o, String message) {
		if (o == null) {
			throw new AssertionError(message);
		}
	}

	public static void notNull(Object o) {
		notNull(o, "Passed object was expected to not be null");
	}

	public static void isNull(Object o, String message) {
		if (o != null) {
			throw new AssertionError(message);
		}
	}

	public static void isNull(Object o) {
		isNull(o, "Passed object was expected to be null");
	}

	public static void notReached() {
		throw new AssertionError();
	}
}
