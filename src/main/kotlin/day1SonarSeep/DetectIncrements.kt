package day1SonarSeep

fun detectIncrement(measures: List<Int>): Int {
    return detectIncrementFromIndex(measures, 0)
}

private fun detectIncrementFromIndex(measures: List<Int>, index: Int): Int {
    val noIncrement = 0
    if (measures.isEmpty() || index == measures.size - 1)
        return noIncrement
    val nextIndex = index + 1
    if (measures[nextIndex] > measures[index]) {
        val increment = 1
        return increment + detectIncrementFromIndex(measures, nextIndex)
    }
    return noIncrement + detectIncrementFromIndex(measures, nextIndex)
}