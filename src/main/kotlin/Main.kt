import menu.CreditsMenu
import menu.MainMenu
import menu.OptionsMenu

fun main() {

    MainLoop(
        mainMenu = MainMenu(
            optionsMenu = OptionsMenu(),
            creditsMenu = CreditsMenu(),
           )
    ).loop()
}