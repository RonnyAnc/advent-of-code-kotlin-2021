package day3BinaryDiagnosis

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Path

class CalculatePowerConsumptionShould {
    @Test
    fun `return no power consumption when file is empty`() {
        val diagnosisReportFile = kotlin.io.path.createTempFile()
        val powerConsumption = calculatePowerConsumption(diagnosisReportFile)
        assertEquals(0, powerConsumption)
    }

    private fun calculatePowerConsumption(diagnosisReportFile: Path): Int {
        return 0
    }
}