data class Field(
    val sizeX: Int,
    val sizeY: Int,
    val field: List<List<FieldObject>> = List(sizeX) { List(sizeY) { FieldObject.Empty } }
)

fun Field.showField() {
    println(field.joinToString("\n") { row ->
        row.joinToString("") { it.symbol }
    })
}