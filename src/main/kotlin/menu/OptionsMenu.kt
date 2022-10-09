package menu

import Options

class OptionsMenu {

    private var isExit: Boolean = false
    fun loop() {
        do {
            showMenu()

            when (readLine()?.toInt() ?: 0) {
                1 -> showCurrentOptions()

                2 -> changeOptions()

                3 -> {
                    isExit = true
                }

                else -> {
                    println("Command not recognized! Please try again")
                }
            }
        } while (!isExit)
    }

    private fun showMenu() {
        println(
            """
        <====================================================================>
        Select make your choice and press Enter:
          1: Show current options
          2: Change options
          3: Exit
    """.trimIndent()
        )
    }

    private fun showCurrentOptions() {
        println(
            """
        Current options:
          sizeX: ${Options.sizeX}
          sizeY: ${Options.sizeY}
          amount of enemies: ${Options.amountOfEnemies}
          amount of flowers: ${Options.amountOfFlowers}
          transistors needed: ${Options.transistorsNeeded}
          moves: ${Options.moves}
    """.trimIndent()
        )
    }

    private fun changeOptions() {
        println("Enter a new value for sizeX, leave blank to keep current value \"${Options.sizeX}\": ")
        Options.sizeX = readLine()?.toIntOrNull() ?: Options.sizeX

        println("Enter a new value for sizeY, leave blank to keep current value \"${Options.sizeY}\": ")
        Options.sizeY = readLine()?.toIntOrNull() ?: Options.sizeY

        println("Enter a new value for amount of enemies, leave blank to keep current value \"${Options.amountOfEnemies}\": ")
        Options.amountOfEnemies = readLine()?.toIntOrNull() ?: Options.amountOfEnemies

        println("Enter a new value for amount of flowers, leave blank to keep current value \"${Options.amountOfFlowers}\": ")
        Options.amountOfEnemies = readLine()?.toIntOrNull() ?: Options.amountOfFlowers

        println("Enter a new value for transistors needed, leave blank to keep current value \"${Options.transistorsNeeded}\": ")
        Options.transistorsNeeded = readLine()?.toIntOrNull() ?: Options.transistorsNeeded

        println("Enter a new value for moves, leave blank to keep current value \"${Options.moves}\": ")
        Options.moves = readLine()?.toIntOrNull() ?: Options.moves
    }
}
