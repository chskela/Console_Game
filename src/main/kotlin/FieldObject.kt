sealed class FieldObject(val symbol: String) {
     object  Empty: FieldObject(" . ")

     class Enemy: FieldObject(" % ")
     class Player: FieldObject(" $ ")
     data class Flower(val amount: Int): FieldObject(" $amount ")
}
