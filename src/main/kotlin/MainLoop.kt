import menu.MainMenu

class MainLoop(
    private val mainMenu: MainMenu,
) {

    fun loop() {
        mainMenu.loop()
    }
}