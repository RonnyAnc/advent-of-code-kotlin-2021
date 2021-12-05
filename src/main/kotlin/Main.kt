import day2Dive2.requestSubmarineBatchMovements
import kotlin.io.path.Path

fun main() {
    val movementsFilePath = Path("inputs/day2-input.txt")
    println("Processing input file $movementsFilePath...")
    val result = requestSubmarineBatchMovements(movementsFilePath)
    println("The result of multiplying horizonal * depth is $result")
}

