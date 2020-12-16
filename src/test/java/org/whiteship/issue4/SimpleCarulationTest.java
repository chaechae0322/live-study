package org.whiteship.issue4;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCarulationTest {

    private static SimpleCarulation calc;

    @BeforeAll
    static void setUp() {
        calc = new SimpleCarulation();
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("test start");
    }

    @Test
    @DisplayName("더하기 테스트")
    void add() {
        assertTrue(calc.add(1,2) >= 3);
        assertFalse(calc.add(3,4) < 4);
        assertEquals(calc.add(1,2), 3);
    }

    @Test
    @DisplayName("빼기 테스트")
    void sub() {
        assertAll("Sub Test",
                () -> assertEquals(calc.sub(2,1), 1),
                () -> assertEquals(calc.sub(1,2), -1),
                () -> assertFalse(calc.sub(1,2) > 0),
                () -> assertTrue(calc.sub(3,1) > 0)
        );
    }

    @Test
    void mul() {
        assertAll("Mul Test With Timeout",
                () -> {
                    assertTimeout(Duration.ofSeconds(1), () -> {
                        calc.mul(1,1);
                        Thread.sleep(5000);
                    }, "5초 걸리네요. 1초가 넘었네요.");
                },
                () -> {
                    assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
                        calc.mul(2, 2);
                        Thread.sleep(5000);
                    }, "1초가 넘었을땐 그만할게요.");
                }

        );
    }

    @Test
    void div() {
        Exception exception = assertThrows(
                ArithmeticException.class, () -> calc.div(1,0)
        );
        assertEquals("divided by zero", exception.getMessage());
    }

    @Test
    @Disabled("Not implemented yet")
    void mod() {

    }

    @AfterEach
    void afterEachTest() {
        System.out.println("test end");
    }

    @AfterAll
    static void afterAllTest() {
        System.out.println("all end..");
    }
}