import org.amshove.kluent.`should be`
import org.amshove.kluent.`should throw`
import org.amshove.kluent.invoking
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

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
}