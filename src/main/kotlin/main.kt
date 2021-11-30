import taxiPark.*
import kotlin.math.min
import kotlin.random.Random

fun main(args: Array<String>) {
//    println("Hello World!")
//    println("la suma es de ${suma(2,4)}")
//    weather(23)
//    repeatChar('*', 4)
//    repeatChar()
//    println(isValidIdentifier("gfh$"))
//    val sum = sum(listOf(1, 2, 3))
//    println(sum)
//    val l = listOf(1, 2, 3)
//    println(l.sum())
//    val s1: String? = null
//    val s2: String? = ""
//    val s3: String? = "null"
//    val s4: String? = "  "
//    showSet()
//    println(s1.isEmptyOrNull())
//    println(s2.isEmptyOrNull())
//    println(s3.isEmptyOrNull())
//    println(s4.isEmptyOrNull())
//    println(duplicateNonZero(listOf(3, 0, 5)))
//    val stBu = "bueno"
//    println("ContainsBu: ${stBu.ContainsBu()}")
//    println("Count = ${countChar("adegasert")}")
//    taxiPark.testTaxiPark()
//    println(foo)
//    println(foo)
//    val a = A()
//    a.setUp()
//    a.display()
//    B("a")
//    equals1(Value("abc"), Value("abc")) eq true
//    equals1(Value("abc"), null) eq false
//    equals1(null, Value("abc")) eq false
//    equals1(null, null) eq true
//    equals2(Value("abc"), Value("abc")) eq true
//    equals2(Value("abc"), null) eq false
//    equals2(null, Value("abc")) eq false
//    equals2(null, null) eq true
//    val list = listOf(1, 2, 3)
//    filterNonZero(list).toString() eq "[1, 2, 3]"
//    filterNonZeroGenerated(list).toString() eq "[1, 2, 3]"
//    fibonacci().take(4).toList().toString() eq "[0, 1, 1, 2]"
//    fibonacci().take(10).toList().toString() eq "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
//    val words = Words()
//    with(words) {
//        // The following two lines should compile:
//        "one".record()
//        +"two"
//    }
//    words.toString() eq "[one, two]"

}

//fun suma(a: Int, b: Int) = a + b // Int result is inferred
//enum class Color{
//    RED, GREEN, BLUE
//}
//fun weather(degrees: Int){
//    val (desc, color) =
//        when {
//            degrees < 10 -> Pair("Cold", Color.BLUE)    // degrees < 10 -> "Cold" to Color.BLUE
//            degrees < 25 -> Pair("Mild", Color.GREEN)   // degrees < 25 -> "Mild" to Color.GREEN
//            else -> Pair("Hot", Color.RED)              // else -> "Hot" to Color.RED
//        }
//    println("desc= ${desc} and color= ${color}")
//}
//fun repeatChar(c: Char = '?', s: Int = 2){
//    repeat(s){
//        print(c)
//    }
//}
//fun max(a: Int, b: Int) = if( a > b) a else b

// -
//fun isValidIdentifier(s: String): Boolean{
//    fun isValidCharacter(ch: Char) = ch =='_' || ch.isLetterOrDigit()
//    if (s.isEmpty() || s[0].isDigit()) return false
//    for (ch in s){
//        if(!isValidCharacter(ch)) return false
//    }
//    return true
//}
// -

//fun sum(list: List<Int>): Int {
//    var result = 0
//    for (i in list) {
//        result += i
//    }
//    return result
//}

// -
//fun List<Int>.sum(): Int {
//    var result = 0
//    for (i in this){
//        result += i
//    }
//    return result
//}
// -

// -
//fun String?.isEmptyOrNull(): Boolean{
//    return this?.length == 0 || this == null
//}
// -

// -
//fun duplicateNonZero(list: List<Int>): List<Int> {
////    return list.flatMap {
////        if (it == 0) return listOf()
////        listOf(it, it)
////    }
//    return list.flatMap { if (it == 0) return@flatMap listOf()
//        listOf(it, it) }
//}
// -

//fun String.ContainsBu(): Boolean{
//    return this.contains("bu")
//}

//fun countChar(str: String) : Int{
//    var count = 0
//    val VOWELS = "aeiou"
//    for (i in VOWELS.indices) {
//        val tCount = str.count { it == VOWELS[i] }
//        count += tCount
//    }
//    return count
//}

//fun showSet(){
//    val setOne = setOf<Int>(1, 3, 5, 6, 1)
//    for (i in setOne){
//        println(i)
//    }
//}
//
//fun testTaxiPark(){
//    val dr1 = Driver("A")
//    val dr2 = Driver("B")
//    val dr3 = Driver("C")
//
//    val ps1 = Passenger("Z")
//    val ps2 = Passenger("Y")
//    val ps3 = Passenger("X")
//    val ps4 = Passenger("W")
//    val ps5 = Passenger("V")
//
//    val tr1 = Trip(dr1, setOf(ps1, ps3), 3, 10.0)
//    val tr2 = Trip(dr2, setOf(ps4), 1, 4.0)
//    val tr3 = Trip(dr3, setOf(ps2, ps5, ps1), 10, 100.0)
//
//    val setDrivers = setOf<Driver>(dr1, dr2, dr3)
//    val setPassengers = setOf<Passenger>(ps1, ps2, ps3, ps4, ps5)
//
//    val listTrip = listOf<Trip>(
//        tr1, tr2, tr3
//    )
//
//    val tp = TaxiPark(setDrivers, setPassengers, listTrip)
//    val tpAllDrivers = tp.allDrivers
//    for (i in tpAllDrivers){
//        println(i)
//    }
//    println(tp.allPassengers.size)
//}

//fun TaxiPark.checkParetoPrinciple(): Boolean {
//    if (trips.isEmpty()) return false
//
//    val totalIncome = trips.sumByDouble(Trip::cost)
//    val sortedDriversIncome: List<Double> = trips
//        .groupBy(Trip::driver)
//        .map { (_, tripsByDriver) -> tripsByDriver.sumByDouble(Trip::cost}
//        .sortedDescending()
//
//    val numberOfTopDrivers = (0.2 * allDrivers.size).toInt()
//    val incomeByTopDrivers = sortedDriversIncome
//        .take(numberOfTopDrivers)
//        .sum()
//
//    return incomeByTopDrivers >= 0.8 * totalIncome
//}
//
//fun main(args: Array<String>) {
//    taxiPark(1..5, 1..4,
//        trip(1, 1, 20, 20.0),
//        trip(1, 2, 20, 20.0),
//        trip(1, 3, 20, 20.0),
//        trip(1, 4, 20, 20.0),
//        trip(2, 1, 20, 19.0))
//        .checkParetoPrinciple() eq true
//
//    taxiPark(1..5, 1..4,
//        trip(1, 1, 20, 20.0),
//        trip(1, 2, 20, 20.0),
//        trip(1, 3, 20, 20.0),
//        trip(1, 4, 20, 20.0),
//        trip(2, 1, 20, 21.0))
//        .checkParetoPrinciple() eq false

//val foo: Int
//    //get() = Random.nextInt(0, 10)
//    get() = (0..10).random()

// -
//class A {
//    private lateinit var prop: String
//
//    fun setUp() {
//        prop = "value"
//    }
//
//    fun display() {
//        println(prop)
//    }
//}
// -

// -
//open class A(open val value: String?){
//    init {
//        value?.length
//    }
//}
//class B(override val value: String) : A(value)
// -

// -
//data class Value(val s: String)
//fun equals1(v1: Value?, v2: Value?): Boolean {
//    return v1 == v2
//}
//fun equals2(v1: Value?, v2: Value?): Boolean = v1?.equals(v2) ?: (v2 === null)
// -

// Inlining of the 'filter' function
//fun filterNonZero(list: List<Int>) = list.filter { it != 0 }
//
//fun filterNonZeroGenerated(list: List<Int>): List<Int> {
//    val destination = ArrayList<Int>()
//    for (element in list) {
//        if (element != 0) {
//            destination.add(element)
//        }
//    }
//    return destination
//}
//
//inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
//    val destination = ArrayList<T>()
//    for (element in this) {
//        if (predicate(element)) {
//            destination.add(element)
//        }
//    }
//    return destination
//}

// Fibonacci Sequence
//fun fibonacci(): Sequence<Int> = sequence {
//    var terms = Pair(0, 1)
//    while(true){
//        yield(terms.first)
//        terms = Pair(terms.second, terms.first + terms.second)
//    }
//}

// - Simplify the following code using more appropriate auxiliary functions (with, let, run, apply, also).
//interface X {
//    var first: Int
//    var second: Int
//    var third: Int
//}
//interface Y {
//    fun start()
//    fun finish()
//}
//interface Z {
//    fun init()
//}
//fun foo(x: X, y: Y?, z: Z) {
//    x.run {
//        first = 1
//        second = 2
//        third = 3
//    }
//    y?.run {
//        start()
//        finish()
//    }
//    val result = z.apply {
//        init()
//    }
//}
// -

// - Implement member extension functions 'record' and 'unaryPlus' so that the code below compiled and stored specified words.
// These functions should be unavailable outside of the 'Words' class.
//class Words {
//    private val list = mutableListOf<String>()
//    fun String.record(){
//        list += this
//    }
//    operator fun String.unaryPlus() {
//        record()
//    }
//    override fun toString() = list.toString()
//}
// -


