class FormulaOneCar {
    var isLifted = false
    var isTyresRemoved = false
    var tyreCount = 4

    fun removeAllTyres() {
        if(!isLifted) {
            return
        }

        if(isTyresRemoved) {
            return
        }
        tyreCount = 0
    }

    fun toggleLiftedState() {
        isLifted = !isLifted
    }

    fun replaceAllTyres() {
        if(!isLifted) {
            return
        }
        if(!isTyresRemoved) {
            return
        }
        tyreCount = 4
    }

}