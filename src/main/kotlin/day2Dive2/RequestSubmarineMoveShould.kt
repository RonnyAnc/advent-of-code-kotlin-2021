package day2Dive2

import java.nio.file.Path

fun requestSubmarineBatchMovements(movementsFilePath: Path): Int {
    val submarine = Submarine()
    movementsFilePath.toFile().forEachLine { instruction ->
        submarine.processInstruction(instruction)
    }
    return submarine.multipliedPositions
}