import java.util.*

fun main() {
    var intentos = 1
    val frutas = listOf("MANZANA", "PERA", "NARANJA", "HIGO", "COCO", "PIMIENTO", "LIMON", "MANGO", "UVA", "NUEZ", "AVELLANA")
    val rnds = (0 until frutas.size).random()
    val fruta = frutas[rnds]
    val numc = fruta.length

    val guion = "_".repeat(numc).toCharArray()

    var rm = ReproductorMidi("pugnodollari.mid")
    println("Cargando juego ...")
    Thread.sleep(2000)

    println("")
    println("           _    _  ____  _____            _____          _____   ____  \n" +
            "     /\\   | |  | |/ __ \\|  __ \\     /\\   / ____|   /\\   |  __ \\ / __ \\ \n" +
            "    /  \\  | |__| | |  | | |__) |   /  \\ | |       /  \\  | |  | | |  | |\n" +
            "   / /\\ \\ |  __  | |  | |  _  /   / /\\ \\| |      / /\\ \\ | |  | | |  | |\n" +
            "  / ____ \\| |  | | |__| | | \\ \\  / ____ \\ |____ / ____ \\| |__| | |__| |\n" +
            " /_/    \\_\\_|  |_|\\____/|_|  \\_\\/_/    \\_\\_____/_/    \\_\\_____/ \\____/ \n" +
            "                                                                       \n" +
            "                                                                      ")
    Thread.sleep(5000)

    do {
        DibujoAhorcado.dibujar(intentos)
        if(intentos == 7){
            break
        }
        println(guion.joinToString(" "))
        print("Ingresa una letra: ")
        val caracter = readLine()?.uppercase()?.get(0)

        // comproba a palabra
        val aciertos = mutableListOf<Int>()
        for (i in 0 until numc) {
            if (fruta[i] == caracter) {
                aciertos.add(i)
            }
        }

        if (aciertos.isEmpty()) {
            // cambio o numero de intentos
            intentos++
        }

        // cambio os guions coas letras
        for (indice in aciertos) {
            guion[indice] = fruta[indice]
        }

        // comproba a palabra
        if (!guion.contains('_')) {
            println("¡Has ganado! La palabra era $fruta")
            break
        }
        //println(intentos)
    } while (true)

    if (intentos == 7) {
        println("¡Has perdido! La palabra era $fruta")
    }

    rm.cerrar()
    rm = ReproductorMidi("Individual_Drums__Crash_Cymbal.mid")
    Thread.sleep(1000)
    rm.cerrar()
}
