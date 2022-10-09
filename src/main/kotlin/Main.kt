import menu.CreditsMenu
import menu.MainMenu
import menu.OptionsMenu

fun main() {

    MainMenu(
        optionsMenu = OptionsMenu(),
        creditsMenu = CreditsMenu(),
    ).loop()
}