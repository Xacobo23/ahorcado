fun main() {
    val frutas =
        listOf("MANZANA", "PERA", "NARANJA", "HIGO", "COCO", "PIMIENTO", "LIMON", "MANGO", "UVA", "NUEZ", "AVELLANA")
    println(frutas.size)
    val rnds = (1 until frutas.size).random()
    val fruta = frutas[rnds]
    println(fruta)
}