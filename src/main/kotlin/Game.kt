import kotlin.random.Random

class Game(
    private val options: Options,
    private val playingField: PlayingField = PlayingField(options.sizeX to options.sizeY)
) {

    private var transistorsGathered: Int = 0
    private var turnLeft = options.moves
    private var isGameNotFinished: Boolean = true

    private lateinit var player: FieldObject.Player


    fun startGame() {

        playerPlacement()
        enemiesPlacement()
        flowersPlacement()

        while (isGameNotFinished) {
            showScore()
            generateFlowers()
            playingField.showField()
            playerTurn()
            computerTurn()

            checkIfGameNotFinished()
        }
    }

    private fun showScore() {
        println("Turn left: $turnLeft, transistors gathered: $transistorsGathered/${options.transistorsNeeded}")
    }

    private fun flowersPlacement() {
        generateFlowers()
    }

    private fun generateFlowers() {
        val flowersOnField: Int by lazy {
            playingField.field.fold(0) { rowAcc, fieldObjects ->
                rowAcc + fieldObjects.fold(0) { acc, fieldObject ->
                    if (fieldObject is FieldObject.Flower) {
                        acc + 1
                    } else acc
                }
            }
        }
        var repeat = options.amountOfFlowers - flowersOnField

        while (repeat > 0) {
            val x = Random.nextInt(0, options.sizeX)
            val y = Random.nextInt(0, options.sizeY)
            when (playingField.field[y][x]) {
                FieldObject.Empty -> {
                    playingField.field[y][x] = FieldObject.Flower(Random.nextInt(0, 9) + 1)
                    repeat -= 1
                }

                else -> {
                    continue
                }
            }
        }
    }

    private fun enemiesPlacement() {
        var repeat = options.amountOfEnemies
        while (repeat > 0) {
            val x = Random.nextInt(0, options.sizeX)
            val y = Random.nextInt(0, options.sizeY)
            when (playingField.field[y][x]) {
                FieldObject.Empty -> {
                    playingField.field[y][x] = FieldObject.Enemy(x to y)
                    repeat -= 1
                }

                else -> {
                    continue
                }
            }
        }
    }

    private fun playerPlacement() {
        val x = Random.nextInt(0, options.sizeX)
        val y = Random.nextInt(0, options.sizeY)
        player = FieldObject.Player(x to y)
        playingField.field[y][x] = player
    }

    private fun checkIfGameNotFinished() {
    }

    private fun computerTurn() {
    }

    private fun playerTurn() {
        println("Please enter your command and press Enter:")

        val command: String = readLine() ?: ""
        val (x, y) = player.coordinate
        val newCoordinate: Pair<Int, Int> = getNewCoordinate(command, x, y)
        val (newX, newY) = newCoordinate
        val targetField: FieldObject = playingField.field[newY][newX]

        if (targetField !is FieldObject.Enemy) {

            if (targetField is FieldObject.Flower) {
                transistorsGathered += targetField.amount
            }

            playingField.field[y][x] = FieldObject.Empty
            player = player.makeMove(newCoordinate)
            playingField.field[newY][newX] = player
            turnLeft--
        }
    }

    private fun getNewCoordinate(command: String, x: Int, y: Int) = when (command) {
        LEFT -> {
            player.coordinate.copy(first = (x - 1).coerceAtLeast(0))
        }

        RIGHT -> {
            player.coordinate.copy(first = (x + 1).coerceAtMost(playingField.coordinate.first - 1))

        }

        UP -> {
            player.coordinate.copy(second = (y - 1).coerceAtLeast(0))
        }

        DOWN -> {
            player.coordinate.copy(second = (y + 1).coerceAtMost(playingField.coordinate.second - 1))
        }

        else -> {
            player.coordinate
        }
    }
}
