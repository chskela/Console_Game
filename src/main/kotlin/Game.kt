import kotlin.random.Random

class Game(
    private val options: Options,
    private val playingField: PlayingField = PlayingField(options.sizeX, options.sizeY)
) {

    val transistorsGathered: Int = 0
    private var isGameNotFinished: Boolean = true
    private var flowersList = listOf<FieldObject.Flower>()

    fun startGame() {

        playerPlacement()
        enemiesPlacement()
        flowersPlacement()
        playingField.showField()
        while (isGameNotFinished) {

            playerTurn()
            computerTurn()
            checkIfGameNotFinished()
        }
    }

    private fun flowersPlacement() {
        generateFlowers()
    }

    private fun generateFlowers() {
        var repeat = options.amountOfFlowers - flowersList.size

        while (repeat > 0) {
            val x = Random.nextInt(0, options.sizeX)
            val y = Random.nextInt(0, options.sizeY)
            when (playingField.field[x][y]) {
                FieldObject.Empty -> {
                    val flower = FieldObject.Flower(Random.nextInt(0, 9) + 1)
                    playingField.field[x][y] = flower
                    flowersList = flowersList + flower
                    repeat -= 1
                }
                else -> {}
            }
        }
    }

    private fun enemiesPlacement() {
    }

    private fun playerPlacement() {
    }

    private fun checkIfGameNotFinished() {
    }

    private fun computerTurn() {
    }

    private fun playerTurn() {
    }

}