data class PlayingField(
    val coordinate: Pair<Int, Int>,
    val field: MutableList<MutableList<FieldObject>> = MutableList(coordinate.second) { MutableList(coordinate.first) { FieldObject.Empty } }
)

fun PlayingField.showField() {
    println(field.joinToString("\n") { row ->
        row.joinToString("") { it.symbol }
    })
}