package mastermind

import kotlin.math.min

const val RIGHT_LETTERS = "ABCDEF"

data class Evaluation (val rightPosition: Int, val wrongPosition: Int)

fun evaluateCode(secret: String, guess: String): Evaluation {
    var wrongPosition = 0
    val rightPosition = getRightPosition(secret, guess)
    if (rightPosition != secret.length) {
        val rightLetters = getRightLetters(secret, guess)
        wrongPosition = rightLetters - rightPosition
    }
    return Evaluation(rightPosition, wrongPosition)
}

fun getRightPosition(secret: String, guess: String) : Int {
    var rightPosition = 0
    for (i in secret.indices) {
        for (j in guess.indices) {
            if (guess[j] == secret[i] && j == i) rightPosition += 1
        }
    }
    return rightPosition
}

fun getRightLetters(secret: String, guess: String) : Int {
    var rightLetters = 0
    for (i in RIGHT_LETTERS.indices) {
        val rLetters = min(guess.count { it == RIGHT_LETTERS[i] }, secret.count { it == RIGHT_LETTERS[i] })
        rightLetters += rLetters
    }
    return rightLetters
}