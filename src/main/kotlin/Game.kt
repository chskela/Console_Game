class Game(
    private val options: Options,
    private val field: Field = Field(options.sizeX, options.sizeY)
) {

    val transistorsGathered: Int = 0
    private var isGameNotFinished: Boolean = true

    fun startGame() {

        playerPlacement()
        enemiesPlacement()
        transistorsPlacement()

        while (isGameNotFinished){
            field.showField()
            playerTurn()
            computerTurn()
            checkIfGameNotFinished()
        }
    }

    private fun transistorsPlacement() {
        TODO("Not yet implemented")
    }

    private fun enemiesPlacement() {
        TODO("Not yet implemented")
    }

    private fun playerPlacement() {
        TODO("Not yet implemented")
    }

    private fun checkIfGameNotFinished() {
        TODO("Not yet implemented")
    }

    private fun computerTurn() {
        TODO("Not yet implemented")
    }

    private fun playerTurn() {
        TODO("Not yet implemented")
    }

}