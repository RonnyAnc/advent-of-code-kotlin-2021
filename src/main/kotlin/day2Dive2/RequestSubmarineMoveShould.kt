package day2Dive2

import java.nio.file.Path

fun requestSubmarineBatchMovements(movementsFilePath: Path): Int {
    var horizontal = 0
    var depth = 0
    movementsFilePath.toFile().forEachLine { instruction ->
        when {
            instruction.startsWith("forward") ->
                horizontal += extractNumberFrom(instruction)
            instruction.startsWith("down") ->
                depth += extractNumberFrom(instruction)
            instruction.startsWith("up") ->
                depth -= extractNumberFrom(instruction)
        } }
    return horizontal * depth
}

private fun extractNumberFrom(it: String) = it.filter { it.isDigit() }.toInt()