import menu.CreditsMenu
import menu.MainMenu
import menu.OptionsMenu

class MainLoop(
    private val mainMenu: MainMenu,
    private val optionsMenu: OptionsMenu,
    private val creditsMenu: CreditsMenu,
    private val game: Game
) {
    private var isStopGame: Boolean = false
    fun loop() {
        do {
            mainMenu.showMenu()

            when (readLine()?.toInt() ?: 0) {
                1 -> game.startNewGame()

                2 -> optionsMenu.showMenu()

                3 -> creditsMenu.showMenu()

                4 -> {
                    isStopGame = true
                }

                else -> {
                    println("Command not recognized! Please try again")
                }
            }
        } while (isStopGame)
    }
}