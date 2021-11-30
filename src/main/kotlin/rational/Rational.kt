package rational

import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO


fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}

class Rational(n: BigInteger, d: BigInteger): Comparable<Rational> {
    val num: BigInteger
    val dem: BigInteger
    init {
        require(d != ZERO) { "denominator is `0`" }
        val gcd = n.gcd(d)
        val sign = d.signum().toBigInteger()
        num = sign * n / gcd
        dem = sign * d / gcd
    }

    operator fun plus(r: Rational) = Rational((num * r.dem) + (r.num * dem), dem * r.dem)
    operator fun minus(r: Rational) = Rational((num * r.dem) - (r.num * dem),dem * r.dem)
    operator fun times(r: Rational) = Rational(num * r.num, dem * r.dem)
    operator fun div(r: Rational) = Rational(num * r.dem, dem * r.num)
    operator fun unaryMinus() = Rational(-num, dem)

    override operator fun compareTo(other: Rational): Int =
        (num * other.dem).compareTo(other.num * dem)

    override fun toString(): String =
        if (dem != ONE) "$num/$dem"
        else "$num"

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Rational -> false
        num != other.num -> false
        dem != other.dem -> false
        else -> true
    }

    override fun hashCode(): Int {
        var result = num.hashCode()
        result = 31 * result + dem.hashCode()
        return result
    }

}

fun String.toRational(): Rational {
    val (n, d) = try {
        if (contains("/")) split("/").map(::BigInteger)
        else listOf(BigInteger(this), ONE)
    } catch (e: Exception) {
        throw IllegalArgumentException("Expecting 'n/d' or 'n', but got $this", e)
    }
    return Rational(n, d)
}

infix fun Int.divBy(r2: Int) : Rational = Rational(toBigInteger(), r2.toBigInteger())
infix fun Long.divBy(r2: Long) : Rational = Rational(toBigInteger(), r2.toBigInteger())
infix fun BigInteger.divBy(r2: BigInteger) : Rational = Rational(this, r2)