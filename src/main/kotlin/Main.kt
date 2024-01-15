fun main() {
    var intentos = 1
    val frutas =
        listOf("MANZANA", "PERA", "NARANJA", "HIGO", "COCO", "PIMIENTO", "LIMON", "MANGO", "UVA", "NUEZ", "AVELLANA")
    val rnds = (0 until frutas.size).random()
    val fruta = frutas[rnds]
    val numc = fruta.length

    // Inicializar la palabra oculta con guiones bajos
    var guion = "_".repeat(numc).toCharArray()

    do {
        DibujoAhorcado.dibujar(intentos)
        println(guion.joinToString(" "))
        print("Ingresa una letra: ")
        val caracter = readLine()?.toUpperCase()?.get(0)

        // Verificar si la letra ingresada está en la palabra
        val aciertos = mutableListOf<Int>()
        for (i in 0 until numc) {
            if (fruta[i] == caracter) {
                aciertos.add(i)
            }
        }

        if (aciertos.isEmpty()) {
            // Incrementar el número de intentos solo si la letra es incorrecta
            intentos++
        }

        // Actualizar los guiones bajos con las letras correctas
        for (indice in aciertos) {
            guion[indice] = fruta[indice]
        }

        // Verificar si se ha adivinado la palabra
        if (!guion.contains('_')) {
            println("¡Felicidades! Has adivinado la palabra: $fruta")
            break
        }

    } while (intentos < 8)

    if (intentos >= 8) {
        println("¡Lo siento! Has agotado todos tus intentos. La palabra era: $fruta")
    }
}
