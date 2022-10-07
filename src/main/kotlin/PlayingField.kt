data class PlayingField(
    private val size: Pair<Int, Int>,
    val field: MutableList<MutableList<FieldObject>> = MutableList(size.second) { MutableList(size.first) { FieldObject.Empty } }
)

fun PlayingField.showField() {
    println(field.joinToString("\n") { row ->
        row.joinToString("") { it.symbol }
    })
}