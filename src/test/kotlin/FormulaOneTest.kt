import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class FormulaOneCarTest {
    private val ferrari = FormulaOneCar()

    @Nested
    inner class `tyre removal` {

        @Test
        fun `should remove all tyres`() {
            ferrari.toggleLiftedState()
            ferrari.removeAllTyres()
            ferrari.tyreCount() `should be` 0
        }

        @Test
        fun `should throw exception if tyres have not been removed`() {
            // given
            ferrari.toggleTyreRemovalState()
            ferrari.toggleLiftedState()

            // then
            invoking { ferrari.removeAllTyres() } `should throw` TyreException::class
        }

        @Test
        fun `should throw exception if car have not been lifted before the removal of the tyres`() {
            invoking { ferrari.removeAllTyres() } `should throw` TyreException::class
        }
    }

    @Nested
    inner class `tyre installation` {
        @Test
        fun `should install all tyres`() {
            ferrari.toggleLiftedState()
            ferrari.installTyres()
            ferrari.tyreCount() `should be` 4
        }

        @Test
        fun `should throw exception if tyres have not been removed`() {
            // given
            ferrari.toggleLiftedState()

            // then
            invoking { ferrari.installTyres() } `should throw` TyreException::class
        }

        @Test
        fun `should throw exception if car have not been lifted before the installation of the tyres`() {
            invoking { ferrari.installTyres() } `should throw` TyreException::class
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class `tyre count` {
        @ParameterizedTest
        @MethodSource("tyreCountBoundaries")
        fun `should not be lower or higher than 4`(tyreCount: Int){
        }

        @Suppress("unused")
        fun tyreCountBoundaries() = listOf(3,4,5)
    }
}