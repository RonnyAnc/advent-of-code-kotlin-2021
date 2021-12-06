package day3BinaryDiagnosis

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Path
import kotlin.io.path.writeText

class CalculatePowerConsumptionShould {
    @Test
    fun `return no power consumption when file is empty`() {
        val diagnosisReportFile = kotlin.io.path.createTempFile()
        val powerConsumption = calculatePowerConsumption(diagnosisReportFile)
        assertEquals(0, powerConsumption)
    }

    @Test
    fun `return when file contains a single 1 bit`() {
        val diagnosisReportPath = kotlin.io.path.createTempFile()
        diagnosisReportPath.writeText("""
            1
        """.trimIndent())
        val powerConsumption = calculatePowerConsumption(diagnosisReportPath)
        assertEquals(1, powerConsumption)
    }

    private fun calculatePowerConsumption(diagnosisReportFile: Path): Int {
        var containsAnyLine = false
        diagnosisReportFile.toFile().forEachLine {
            containsAnyLine = true
        }
        if (containsAnyLine) return 1
        return 0
    }
}