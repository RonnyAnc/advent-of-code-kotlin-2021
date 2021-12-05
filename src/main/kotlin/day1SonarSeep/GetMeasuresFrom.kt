package day1SonarSeep

import java.io.File

fun getMeasuresFrom(filePath: String): MutableList<Int> {
    val measures = emptyList<Int>().toMutableList()
    File(filePath).forEachLine { measures.add(it.toInt()) }
    return measures
}