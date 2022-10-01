data class PlayingField(
    val sizeX: Int,
    val sizeY: Int,
    val field: MutableList<MutableList<FieldObject>> = MutableList(sizeX) { MutableList(sizeY) { FieldObject.Empty } }
)

fun PlayingField.showField() {
    println(field.joinToString("\n") { row ->
        row.joinToString("") { it.symbol }
    })
}