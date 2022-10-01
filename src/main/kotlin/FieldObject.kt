sealed class FieldObject(val symbol: String) {
    object Empty : FieldObject(" . ")

    class Enemy : FieldObject(" % ")

    data class Player(val coordinate: Pair<Int, Int>) : FieldObject(" @ ")

    data class Flower(val amount: Int) : FieldObject(" $amount ")
}


fun FieldObject.Player.makeMove(coordinate: Pair<Int, Int>): FieldObject.Player = this.copy(coordinate = coordinate)