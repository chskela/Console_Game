package menu

class OptionsMenu {
    fun showMenu(): String {
        return """
        Select make your choice and press Enter:
          1: Show current settings
          2: Change settings
          3: Exit
    """.trimIndent()
    }
}