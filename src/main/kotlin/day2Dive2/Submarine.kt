package day2Dive2

class Submarine {
    private var depth = 0
    private var horizontal = 0
    val multipliedPositions
        get() = horizontal * depth

    fun processInstruction(instruction: String) {
        val increment = extractNumberFrom(instruction)
        when {
            instruction.startsWith("forward") ->
                moveForward(increment)
            instruction.startsWith("down") ->
                increaseDepth(increment)
            instruction.startsWith("up") ->
                decreaseDepth(increment)
        }
    }

    private fun moveForward(increment: Int) {
        horizontal += increment
    }

    private fun increaseDepth(increment: Int) {
        depth += increment
    }

    private fun decreaseDepth(decrement: Int) {
        increaseDepth(-decrement)
    }

    private fun extractNumberFrom(instruction: String) =
        instruction.filter { it.isDigit() }.toInt()
}