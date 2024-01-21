class TimestampTest {

    public static void main(String[] args) {
        testParseValidTimestamp();
        testParseInvalidTimestamp();
        testToString();
        testSettersAndGetters();
        testInvalidTimestampYear();
        testInvalidTimestampMonth();
        testInvalidTimestampDay();
        testInvalidTimestampHour();
        testInvalidTimestampMinute();
        testInvalidTimestampSecond();
    }

    static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError("Assertion failed: expected " + expected + ", but got " + actual);
        }
    }

    static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Assertion failed: expected \"" + expected + "\", but got \"" + actual + "\"");
        }
    }

    static void assertThrows(Class<? extends Exception> expectedException, Runnable runnable) {
        try {
            runnable.run();
            throw new AssertionError("Assertion failed: Expected exception " + expectedException.getSimpleName() + " not thrown.");
        } catch (Exception e) {
            if (!expectedException.isInstance(e)) {
                throw new AssertionError("Assertion failed: Expected exception " + expectedException.getSimpleName() + ", but got " + e.getClass().getSimpleName());
            }
        }
    }

    static void testParseValidTimestamp() {
        Timestamp timestamp = Timestamp.parse("2022-01-21T12:34:56");

        assertEquals(2022, timestamp.getYear());
        assertEquals(1, timestamp.getMonth());
        assertEquals(21, timestamp.getDay());
        assertEquals(12, timestamp.getHour());
        assertEquals(34, timestamp.getMinute());
        assertEquals(56, timestamp.getSecond());
    }

    static void testParseInvalidTimestamp() {
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp.parse("invalid_timestamp");
        });
    }

    static void testToString() {
        Timestamp timestamp = Timestamp.parse("2022-01-21T12:34:56");
        assertEquals("2022-01-21T12:34:56", timestamp.toString());
    }

    static void testSettersAndGetters() {
        Timestamp timestamp = Timestamp.parse("2022-01-21T12:34:56");

        timestamp.setYear(2023);
        timestamp.setMonth(2);
        timestamp.setDay(22);
        timestamp.setHour(13);
        timestamp.setMinute(45);
        timestamp.setSecond(57);

        assertEquals(2023, timestamp.getYear());
        assertEquals(2, timestamp.getMonth());
        assertEquals(22, timestamp.getDay());
        assertEquals(13, timestamp.getHour());
        assertEquals(45, timestamp.getMinute());
        assertEquals(57, timestamp.getSecond());
    }

    static void testInvalidTimestampYear() {
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp.parse("10000-01-01T00:00:00");
        });
    }

    static void testInvalidTimestampMonth() {
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp.parse("2022-13-01T00:00:00");
        });
    }

    static void testInvalidTimestampDay() {
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp.parse("2022-01-32T00:00:00");
        });
    }

    static void testInvalidTimestampHour() {
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp.parse("2022-01-01T24:00:00");
        });
    }

    static void testInvalidTimestampMinute() {
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp.parse("2022-01-01T00:60:00");
        });
    }

    static void testInvalidTimestampSecond() {
        assertThrows(IllegalArgumentException.class, () -> {
            Timestamp.parse("2022-01-01T00:00:60");
        });
    }
}

