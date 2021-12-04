import kotlin.test.Test
import kotlin.test.assertEquals

class DetectIncrementsShould {
    @Test
    fun not_detect_any_increment_when_no_measures_were_given() {
        assertEquals(0, detectIncrement(emptyList()))
    }

    @Test
    fun detect_an_increment_when_a_measure_is_bigger_than_the_previous_one() {
        assertEquals(1, detectIncrement(listOf(0, 1)))
    }

    @Test
    fun not_detect_an_increment_when_a_measure_is_not_bigger_than_the_previous_one() {
        assertEquals(0, detectIncrement(listOf(1, 1)))
    }

    @Test
    fun detect_an_increment_when_a_measure_is_not_bigger_than_the_previous_one_with_more_than_two() {
        assertEquals(1, detectIncrement(listOf(1, 3, 1)))
    }

    private fun detectIncrement(measures: List<Int>): Int {
        return detectIncrementFromIndex(measures, 0)
    }

    private fun detectIncrementFromIndex(measures: List<Int>, index: Int): Int {
        if (measures.isEmpty() || index == measures.size - 1)
            return 0
        if (measures[index + 1] > measures[index]) {
            return 1 + detectIncrementFromIndex(measures, index + 1)
        }
        return 0 + detectIncrementFromIndex(measures, index + 1)
    }
}