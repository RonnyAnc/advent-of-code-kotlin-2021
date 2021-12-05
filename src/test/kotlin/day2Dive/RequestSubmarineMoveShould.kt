package day2Dive

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.nio.file.Path
import java.util.stream.Stream
import kotlin.io.path.writeText

class RequestSubmarineMoveShould {
    @Test
    fun `retrieve 0 when no movement ordered`() {
        val movementRequestsFile = kotlin.io.path.createTempFile()
        val result = requestSubmarineBatchMovements(movementRequestsFile)
        assertEquals(0, result)
    }

    @ParameterizedTest
    @MethodSource("movements")
    fun `retrieve non 0 when it was moved horizontally and vertically`(movements: String, expectedOutput: Int) {
        val movementRequestsFile = kotlin.io.path.createTempFile()
        movementRequestsFile.writeText(movements.trimIndent())
        val result = requestSubmarineBatchMovements(movementRequestsFile)
        assertEquals(expectedOutput, result)
    }

    companion object TestMovements {
        @JvmStatic
        fun movements(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("""
                    forward 1
                    down 1
                """.trimIndent(), 1),
                Arguments.of("""
                    forward 1
                    down 2
                """.trimIndent(), 2),
            )
        }
    }

    private fun requestSubmarineBatchMovements(movementsFilePath: Path): Int {
        var horizontal = 0
        var depth = 0
        movementsFilePath.toFile().forEachLine { when {
            it.startsWith("forward") -> horizontal += it.filter { it.isDigit() }.toInt()
            it.startsWith("down") -> depth += it.filter { it.isDigit() }.toInt()
        } }
        return horizontal * depth
    }
}
