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
          rows: ${Options.rows}
          columns: ${Options.columns}
          amount of enemies: ${Options.amountOfEnemies}
          transistors needed: ${Options.transistorsNeeded}
          moves: ${Options.moves}
    """.trimIndent()
        )
    }

    private fun changeOptions() {
        println("Enter a new value for rows: ")
        Options.rows = readLine()?.toInt() ?: Options.rows
        println("Enter a new value for columns: ")
        Options.columns = readLine()?.toInt() ?: Options.columns
        println("Enter a new value for amount of enemies: ")
        Options.amountOfEnemies = readLine()?.toInt() ?: Options.amountOfEnemies
        println("Enter a new value for transistors needed: ")
        Options.transistorsNeeded = readLine()?.toInt() ?: Options.transistorsNeeded
        println("Enter a new value for moves: ")
        Options.moves = readLine()?.toInt() ?: Options.moves
    }
}
