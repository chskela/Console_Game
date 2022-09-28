package menu

import Game

class MainMenu(
    private val optionsMenu: OptionsMenu,
    private val creditsMenu: CreditsMenu,
    private val game: Game
) {
    private var isExit: Boolean = false

    fun loop() {
        do {
            showMenu()

            when (readLine()?.toInt() ?: 0) {
                1 -> game.startNewGame()

                2 -> optionsMenu.loop()

                3 -> creditsMenu.showMenu()

                4 -> {
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
        Welcome to Console Game v1.0. Please make your choice and press Enter:
          1: Start new game
          2: Options
          3: Credits
          4: Exit
    """.trimIndent()
        )
    }
}
