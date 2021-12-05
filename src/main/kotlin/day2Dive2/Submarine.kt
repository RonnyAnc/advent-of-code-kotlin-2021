package day2Dive2

class Submarine {
    private var depth = 0
    private var horizontal = 0
    private var aim = 0
    val multipliedPositions
        get() = horizontal * depth

    fun processInstruction(instruction: String) {
        val increment = extractNumberFrom(instruction)
        when {
            instruction.startsWith("forward") ->
                move(increment)
            instruction.startsWith("down") ->
                increaseDepth(increment)
            instruction.startsWith("up") ->
                decreaseDepth(increment)
        }
    }

    private fun move(increment: Int) {
        horizontal += increment
        depth += increment * aim
    }

    private fun increaseDepth(increment: Int) {
        aim += increment
    }

    private fun decreaseDepth(decrement: Int) {
        increaseDepth(-decrement)
    }

    private fun extractNumberFrom(instruction: String) =
        instruction.filter { it.isDigit() }.toInt()
}