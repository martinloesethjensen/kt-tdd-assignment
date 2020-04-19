class FormulaOneCar {
    private var isLifted = false
    private var isTiresRemoved = false
    private var tireCount = 4

    fun removeAllTires() {
        if(!isLifted) {
            throw TireException("Car should be lifted before tire removal")
        }

        if(isTiresRemoved) {
            throw TireException("Tires have already been removed")
        }

        tireCount = 0
    }

    fun toggleLiftedState() {
        isLifted = !isLifted
    }

    fun tireCount() = tireCount

    fun toggleTireRemovalState() {
        isTiresRemoved = ! isTiresRemoved
    }

    fun installTires() {
        if(!isLifted) {
            throw TireException("Car should be lifted before installation of tires")
        }
        if(!isTiresRemoved) {
            throw TireException("Old tires need to be removed before the installation of new tires")
        }
        tireCount = 4
    }

}