import org.amshove.kluent.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class FormulaOneCarTest {
    val ferrari = FormulaOneCar()

    @Test
    fun `remove all tyres`() {
        ferrari.toggleLiftedState()
        ferrari.removeAllTyres()
        ferrari.tyreCount `should be` 0
    }

    @Test
    fun `should throw exception if tyres have not been removed`() {
        invoking{ ferrari.removeAllTyres() } `should throw` TyreRemovalException::class

    }

    @Test
    fun `replace all tyres`() {
        ferrari.toggleLiftedState()
        ferrari.replaceAllTyres()
        ferrari.tyreCount `should be` 4
    }

    /*@Nested @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class `toggle car lift switch` {
        @ParameterizedTest @MethodSource
        fun `lift the car`(){

        }
    }*/
}