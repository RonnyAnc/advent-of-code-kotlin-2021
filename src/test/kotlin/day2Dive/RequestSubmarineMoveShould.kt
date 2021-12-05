package day2Dive

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Path

class RequestSubmarineMoveShould {
    @Test
    fun `retrieve 0 when no movement ordered`() {
        val movementRequestsFile = kotlin.io.path.createTempFile()
        val result = requestSubmarineBatchMovements(movementRequestsFile)
        assertEquals(0, result)
    }

    private fun requestSubmarineBatchMovements(movementRequestsFile: Path): Int {
        return 0
    }
}
