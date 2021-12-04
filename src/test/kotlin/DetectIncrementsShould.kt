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
    fun not_detect_an_increment_when_a_measure_is_not_bigger_than_the_previous_one(measures: List<Int>) {
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

    private fun detectIncrement(measures: List<Int>): Int {
        return detectIncrementFromIndex(measures, 0)
    }

    private fun detectIncrementFromIndex(measures: List<Int>, index: Int): Int {
        val noIncrement = 0
        if (measures.isEmpty() || index == measures.size - 1)
            return noIncrement
        val nextIndex = index + 1
        if (measures[nextIndex] > measures[index]) {
            val increment = 1
            return increment + detectIncrementFromIndex(measures, nextIndex)
        }
        return noIncrement + detectIncrementFromIndex(measures, nextIndex)
    }
}