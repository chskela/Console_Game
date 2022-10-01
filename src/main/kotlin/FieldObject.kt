sealed class FieldObject(val symbol: String) {
     object Empty: FieldObject(" . ")

     class Enemy: FieldObject(" % ")
     data class Player(val x: Int, val y: Int): FieldObject(" @ ")
     data class Flower(val amount: Int): FieldObject(" $amount ")
}

const val LEFT = "a"
const val RIGHT = "d"
const val UP = "w"
const val DOWN = "s"
fun FieldObject.Player.makeMove(command: String): FieldObject.Player = when(command) {
     LEFT -> this.copy(x = this.x - 1, y = this.y)
     RIGHT -> this.copy(x = this.x + 1, y = this.y)
     UP -> this.copy(x = this.x, y = this.y - 1)
     DOWN -> this.copy(x = this.x, y = this.y + 1)
     else -> this
}