package day1SonarSeep

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DetectIncrementsShould {
    @Test
    fun `not detect any increment when no measures were given`() {
        assertEquals(0, detectIncrement(emptyList()))
    }

    @ParameterizedTest
    @MethodSource("detectIncrementParameters")
    fun `detect an increment when a measure is bigger than the previous one`(measures: List<Int>, expectedIncrements: Int) {
        assertEquals(expectedIncrements, detectIncrement(measures))
    }

    @ParameterizedTest
    @MethodSource("doesNotDetectIncrementParameters")
    fun `not detect an increment when a measure is not bigger than the previous one`(measures: List<Int>) {
        assertEquals(0, detectIncrement(measures))
    }

    companion object DetectIncrementTestParameters {
        @JvmStatic
        fun detectIncrementParameters(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(0, 1), 1),
                Arguments.of(listOf(0, 1, 2), 2),
                Arguments.of(listOf(0, 1, 2, 3), 3),
                Arguments.of(listOf(0, 1, 1, 2), 2),
            )

        @JvmStatic
        fun doesNotDetectIncrementParameters(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(1, 0)),
                Arguments.of(listOf(50, 20, 20, 5)),
                Arguments.of(listOf(1, 1, 1, 1)),
            )
    }
}

