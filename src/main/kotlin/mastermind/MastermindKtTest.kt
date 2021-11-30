package mastermind

import org.junit.Assert
import org.junit.Test

internal class MastermindKtTest{
    private fun testEvaluation(secret: String, guess: String, rightPosition: Int, wrongPosition: Int) {
        val expected = Evaluation(rightPosition, wrongPosition)
        val evaluation = evaluateCode(secret, guess)
        Assert.assertEquals("ERROR: secret=$secret, code=$guess",
            expected, evaluation)
    }

    private fun testRightLetters(secret: String, guess: String, rightLetters: Int) {
        val evaluation = getRightLetters(secret, guess)
        Assert.assertEquals("ERROR: secret=$secret, code=$guess",
            rightLetters, evaluation)
    }

    private fun testRightPosition(secret: String, guess: String, rightPosition: Int) {
        val evaluation = getRightPosition(secret, guess)
        Assert.assertEquals("ERROR: secret=$secret, code=$guess",
            rightPosition, evaluation)
    }

    //testEvaluation
    @Test
    fun test01SampleEqual() = testEvaluation("ABCD", "ABCD", 4, 0)
    @Test
    fun test02SampleOnlyWrongPositions() = testEvaluation("ABCD", "CDBA", 0, 4)
    @Test
    fun test03SampleSwap() = testEvaluation("ABCD", "ABDC", 2, 2)
    @Test
    fun test04RightPositions() = testEvaluation("ABCD", "ABCF", 3, 0)
    @Test
    fun test05WrongPositions() = testEvaluation("DAEF", "FECA", 0, 3)
    @Test
    fun test06BothRightAndWrong() = testEvaluation("ACEB", "BCDF", 1, 1)
    @Test
    fun test07() = testEvaluation("FBAE", "ABCD", 1, 1)
    @Test
    fun test08() = testEvaluation("FBAE", "AFDC", 0, 2)
    @Test
    fun test09() = testEvaluation("FBAE", "CBAE", 3, 0)
    @Test
    fun test10() = testEvaluation("FBAE", "CBFE", 2, 1)
    @Test
    fun test11() = testEvaluation("FBAE", "FBAE", 4, 0)
    @Test
    fun test12() = testEvaluation("EBAC", "ABCD", 1, 2)
    @Test
    fun test13() = testEvaluation("EBAC", "AFCB", 0, 3)
    @Test
    fun test14() = testEvaluation("EBAC", "CBDF", 1, 1)
    @Test
    fun test15() = testEvaluation("EBAC", "EBAC", 4, 0)

    @Test
    fun testt01Sample() = testEvaluation("AABC", "ADFE", 1, 0)

    @Test
    fun testt02Sample() = testEvaluation("AABC", "ADFA", 1, 1)

    @Test
    fun testt3Sample() = testEvaluation("AABC", "DFAA", 0, 2)

    @Test
    fun testet04Sample() = testEvaluation("AABC", "DEFA", 0, 1)

    @Test
    fun testt05() = testEvaluation("ABCD", "EAAA", 0, 1)

    @Test
    fun testt06() = testEvaluation("AABC", "ADFA", 1, 1)

    @Test
    fun testt07() = testEvaluation("AABC", "DEFA", 0, 1)

    @Test
    fun testt08() = testEvaluation("EDEB", "CBFE", 0, 2)

    @Test
    fun testt09() = testEvaluation("CFDF", "FCCD", 0, 3)

    @Test
    fun testt10() = testEvaluation("AABC", "AEFD", 1, 0)

    @Test
    fun testt11() = testEvaluation("DCFC", "ABEC", 1, 0)

    @Test
    fun testt12() = testEvaluation("FDCD", "FBAD", 2, 0)

    @Test
    fun testt13() = testEvaluation("DEFA", "AABC", 0, 1)

    @Test
    fun testt14() = testEvaluation("DAAE", "AABC", 1, 1)

    @Test
    fun testt15() = testEvaluation("BBDC", "DFBB", 0, 3)

    @Test
    fun testt16() = testEvaluation("DBFF", "FFDD", 0, 3)

    @Test
    fun testt17() = testEvaluation("BDAD", "AAAE", 1, 0)

    @Test
    fun testt18() = testEvaluation("FDDB", "CABB", 1, 0)

    @Test
    fun testt19() = testEvaluation("BDBC", "DDFC", 2, 0)

    @Test
    fun testt20() = testEvaluation("ECDE", "CEEE", 1, 2)

    @Test
    fun testt21() = testEvaluation("AAAF", "ABCA", 1, 1)

    @Test
    fun testt22() = testEvaluation("BCDA", "AFEA", 1, 0)

    @Test
    fun testt23() = testEvaluation("EEEE", "AFEA", 1, 0)

    @Test
    fun testt24() = testEvaluation("EEBE", "AFEA", 0, 1)

    @Test
    fun testt25() = testEvaluation("EEAD", "EEEE", 2, 0)

    @Test
    fun testt26() = testEvaluation("BACD", "EAFF", 1, 0)
}