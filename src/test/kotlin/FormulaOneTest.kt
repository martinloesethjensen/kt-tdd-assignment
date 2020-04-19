import org.amshove.kluent.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class FormulaOneCarTest {
    private val ferrari = FormulaOneCar()

    @Nested
    inner class `tire removal` {

        @Test
        fun `should remove all tires`() {
            ferrari.toggleLiftedState()
            ferrari.removeAllTires()
            ferrari.tireCount() `should be` 0
        }

        @Test
        fun `should throw exception if tires have not been removed`() {
            // given
            ferrari.toggleTireRemovalState()
            ferrari.toggleLiftedState()

            // then
            invoking { ferrari.removeAllTires() } `should throw` TireException::class
        }

        @Test
        fun `should throw exception if car have not been lifted before the removal of the tires`() {
            invoking { ferrari.removeAllTires() } `should throw` TireException::class
        }
    }

    @Nested
    inner class `tire installation` {
        @Test
        fun `should install all tires`() {
            ferrari.toggleLiftedState()
            ferrari.toggleTireRemovalState()
            ferrari.installTires()
            ferrari.tireCount() `should be` 4
        }

        @Test
        fun `should throw exception if tires have not been removed`() {
            // given
            ferrari.toggleLiftedState()

            // then
            invoking { ferrari.installTires() } `should throw` TireException::class
        }

        @Test
        fun `should throw exception if car have not been lifted before the installation of the tires`() {
            invoking { ferrari.installTires() } `should throw` TireException::class
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class `tire count` {
        @ParameterizedTest
        @MethodSource("tireCountInvalidBoundaries")
        fun `should not be lower or higher than 4`(count: Int){
            ferrari.tireCount() `should not be` count
        }

        @Suppress("unused")
        fun tireCountInvalidBoundaries() = listOf(0,1,2,3,5,6)
    }
}