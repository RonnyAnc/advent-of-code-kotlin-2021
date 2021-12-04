import kotlin.test.Test
import kotlin.test.assertEquals

class DetectIncrementsShould {
    @Test
    fun not_detect_any_increment_when_no_measures_were_given() {
        assertEquals(0, detectIncrement(emptyList()))
    }

    private fun detectIncrement(emptyList: List<Int>): Int {
        return 0
    }
}