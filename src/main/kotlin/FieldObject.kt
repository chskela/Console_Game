sealed class FieldObject(val symbol: String) {
    object Empty : FieldObject(" . ")

    data class Enemy(val coordinate: Pair<Int, Int>) : FieldObject(" % ")

    data class Player(val coordinate: Pair<Int, Int>) : FieldObject(" @ ")

    data class Flower(val amount: Int) : FieldObject(" $amount ")
}


fun FieldObject.Player.makeMove(coordinate: Pair<Int, Int>): FieldObject.Player = this.copy(coordinate = coordinate)

fun FieldObject.Enemy.makeMove(coordinate: Pair<Int, Int>): FieldObject.Enemy = this.copy(coordinate = coordinate)