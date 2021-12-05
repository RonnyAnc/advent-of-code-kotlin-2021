package day2Dive

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Path
import kotlin.io.path.writeText

class RequestSubmarineMoveShould {
    @Test
    fun `retrieve 0 when no movement ordered`() {
        val movementRequestsFile = kotlin.io.path.createTempFile()
        val result = requestSubmarineBatchMovements(movementRequestsFile)
        assertEquals(0, result)
    }

    @Test
    fun `retrieve non 0 when it was moved horizontally and vertically`() {
        val movementRequestsFile = kotlin.io.path.createTempFile()
        movementRequestsFile.writeText("""
            forward 1
            down 1
        """.trimIndent())
        val result = requestSubmarineBatchMovements(movementRequestsFile)
        assertEquals(1, result)
    }

    private fun requestSubmarineBatchMovements(movementsFilePath: Path): Int {
        var movement = 0
        movementsFilePath.toFile().forEachLine { when {
            it.startsWith("forward") -> movement += 1
        } }
        if (movement != 0 ) return 1
        return 0
    }
}
