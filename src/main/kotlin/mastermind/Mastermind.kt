package mastermind
import java.util.*


val ALPHABET = 'A'..'F'
val LENGTH = 4

fun main(args: Array<String>) {
    playMastermind()
}

fun playMastermind(secret: String = generateSecret()){
    val scanner = Scanner(System.`in`)
    var evaluation: Evaluation
    do {
        println("CODE: ")
        var guess = scanner.next()
        guess = guess.trim().toUpperCase().replace(" ", "")
        while (hasErrorInput(guess)) {
            println("The CODE must have $LENGTH letters " +
                    "and builded with ${ALPHABET.first} to ${ALPHABET.last} " +
                    "in UPPERCASE")
            println("CODE: ")
            guess = scanner.next()
        }
        evaluation = evaluateCode(secret, guess)
        if(!evaluation.isComplete()) {
            println("RightPosition: ${evaluation.rightPosition} " +
                    "\nWrongPosition: ${evaluation.wrongPosition}")
        }

    } while (!evaluation.isComplete())
    println("FINISH!")
}

fun generateSecret() : String {
    val charList = ALPHABET.toMutableList()
    val random = Random()
    return buildString{
        for(i in 1..LENGTH){
            append(charList[random.nextInt(charList.size)])
        }
    }
}

fun Evaluation.isComplete(): Boolean = rightPosition == LENGTH

fun hasErrorInput(guess: String) : Boolean{
    val letters = ALPHABET.toSet()
    return guess.length != LENGTH || guess.any{ it !in letters}
}