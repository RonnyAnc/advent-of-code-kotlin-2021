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
    fun `return 1 when file contains a single 1 bit`() {
        val diagnosisReportPath = kotlin.io.path.createTempFile()
        diagnosisReportPath.writeText("""
            1
        """.trimIndent())
        val powerConsumption = calculatePowerConsumption(diagnosisReportPath)
        assertEquals(1, powerConsumption)
    }

    @Test
    fun `return 0 when files contains a single 0 bit`() {
        val diagnosisReportPath = kotlin.io.path.createTempFile()
        diagnosisReportPath.writeText("""
            0
        """.trimIndent())
        val powerConsumption = calculatePowerConsumption(diagnosisReportPath)
        assertEquals(0, powerConsumption)
    }

    @Test
    fun `multiply gamma per epsilon in a file with single bit reports`() {
        val diagnosisReportPath = kotlin.io.path.createTempFile()
        diagnosisReportPath.writeText("""
            1
            0
            0
        """.trimIndent())
        val powerConsumption = calculatePowerConsumption(diagnosisReportPath)
        assertEquals(0, powerConsumption)
    }

    private fun calculatePowerConsumption(diagnosisReportFile: Path): Int {
        var oneBitCount = 0
        var zeroBitCount = 0
        diagnosisReportFile.toFile().forEachLine {
            if (it == "1") {
                oneBitCount += 1
            } else {
                zeroBitCount += 1
            }
        }
        var gammaDigit = 0
        var epsilonDigit = if (zeroBitCount == 0) 1 else 0
        if (oneBitCount > zeroBitCount) {
            gammaDigit = 1
        } else {
            epsilonDigit = 1
        }
        return gammaDigit * epsilonDigit
    }
}