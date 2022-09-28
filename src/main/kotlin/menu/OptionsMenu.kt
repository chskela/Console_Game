package menu

class OptionsMenu {
    fun showMenu() {
        println(
            """
        Select make your choice and press Enter:
          1: Show current settings
          2: Change settings
          3: Exit
    """.trimIndent()
        )
    }
}
