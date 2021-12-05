package day2Dive

import day2Dive2.requestSubmarineBatchMovements
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
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
                """.trimIndent(), 0),
                Arguments.of("""
                    forward 1
                    down 2
                    forward 2
                """.trimIndent(), 12),
                Arguments.of("""
                    forward 1
                    down 10
                    forward 1
                """.trimIndent(), 20)
            )
        }
    }
}

