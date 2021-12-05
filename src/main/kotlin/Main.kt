import day1SonarSeep.detectIncrement
import day1SonarSeep.getMeasuresFrom

fun main() {
    println("Reading measures...")
    val measures = getMeasuresFrom("inputs/input.txt")
    println("There has been ${detectIncrement(measures)} increments")
}

