sealed class FieldObject(val symbol: String) {
    object Empty : FieldObject(" . ")

    data class Enemy(val coordinate: Pair<Int, Int>) : FieldObject("\u001B[31m % \u001B[0m")

    data class Player(val coordinate: Pair<Int, Int>) : FieldObject("\u001b[1m \u001b[34m @ \u001b[0m")

    data class Flower(val amount: Int) : FieldObject("\u001b[33m $amount \u001B[0m")
}

fun FieldObject.Player.makeMove(coordinate: Pair<Int, Int>): FieldObject.Player = this.copy(coordinate = coordinate)