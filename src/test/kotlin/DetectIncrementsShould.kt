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

    private fun detectIncrement(emptyList: List<Int>): Int {
        if (emptyList.size > 1)
            if (emptyList.first() < emptyList.last())
                return 1
        return 0
    }
}