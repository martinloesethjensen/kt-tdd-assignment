class FormulaOneCar {
    private var isLifted = false
    private var isTyresRemoved = false
    private var tyreCount = 4

    fun removeAllTyres() {
        if(!isLifted) {
            throw TyreException("Car should be lifted before tyre removal")
        }

        if(isTyresRemoved) {
            throw TyreException("Tyres have already been removed")
        }

        tyreCount = 0
    }

    fun toggleLiftedState() {
        isLifted = !isLifted
    }

    fun tyreCount() = tyreCount

    fun toggleTyreRemovalState() {
        isTyresRemoved = ! isTyresRemoved
    }

    fun installTyres() {
        if(!isLifted) {
            throw TyreException("Car should be lifted before installation of tyres")
        }
        if(!isTyresRemoved) {
            throw TyreException("Old tyres need to be removed before the installation of new tyres")
        }
        tyreCount = 4
    }

}