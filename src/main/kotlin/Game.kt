import kotlin.random.Random

class Game(
    private val options: Options,
    private val playingField: PlayingField = PlayingField(options.sizeX to options.sizeY)
) {

    val transistorsGathered: Int = 0
    private var isGameNotFinished: Boolean = true
    private var flowersList = listOf<FieldObject.Flower>()

    private var player: FieldObject.Player = FieldObject.Player(0 to 0)


    fun startGame() {

        playerPlacement()
        enemiesPlacement()
        flowersPlacement()

        while (isGameNotFinished) {
            playingField.showField()
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
            when (playingField.field[y][x]) {
                FieldObject.Empty -> {
                    val flower = FieldObject.Flower(Random.nextInt(0, 9) + 1)
                    playingField.field[y][x] = flower
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
        playingField.field[player.coordinate.second][player.coordinate.first] = player
    }

    private fun checkIfGameNotFinished() {
    }

    private fun computerTurn() {
    }

    private fun playerTurn() {
        val command = readLine() ?: ""
        val (x, y) = player.coordinate
        val newCoordinate: Pair<Int, Int> = when (command) {
            LEFT -> {
                player.coordinate.copy(first = x - 1)
            }

            RIGHT -> {
                player.coordinate.copy(first = x + 1)

            }

            UP -> {
                player.coordinate.copy(second = y - 1)
            }

            DOWN -> {
                player.coordinate.copy(second = y + 1)
            }

            else -> {
                player.coordinate
            }
        }
        val (newX, newY) = newCoordinate

        if (newX in (0 until playingField.coordinate.first)
            && newY in (0 until playingField.coordinate.second)
            && playingField.field[newX][newY] !is FieldObject.Enemy

        ) {
            playingField.field[y][x] = FieldObject.Empty
            player = player.makeMove(newCoordinate)
            playerPlacement()
        }
    }

}


const val LEFT = "a"
const val RIGHT = "d"
const val UP = "w"
const val DOWN = "s"