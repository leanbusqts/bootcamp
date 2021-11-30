package taxiPark

import org.junit.Assert
import org.junit.Test

/*
 * Task #1. Find all the drivers who performed no trips.
 */
//fun TaxiPark.findFakeDrivers(): Set<Driver> =
//    this.allDrivers.filter {it !in this.trips.map { trip: Trip -> trip.driver } }
//                   .toSet()
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    this.allDrivers.filter { driver -> trips.none { it.driver == driver } }
                  .toSet()
/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
//fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
//    this.allPassengers.filter { this.trips.filter { trip: Trip -> it in trip.passengers }
//                                          .count() >= minTrips }
//                      .toSet()
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    this.allPassengers.filter { passenger -> trips.count { passenger in it.passengers } >= minTrips }
                      .toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
//fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
//   this.allPassengers.filter { this.trips.filter { trip: Trip -> it in trip.passengers && trip.driver == driver }
//                                         .count() > 1 }
//                     .toSet()
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    this.allPassengers.filter { passenger -> trips.count { it.driver == driver && passenger in it.passengers } > 1 }
                      .toSet()
/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val (match, rest) = trips.partition { it.discount is Double }
    return allPassengers.filter { passenger ->
        val withDiscount = match.count { it.passengers.contains(passenger) }
        val withoutDiscount = rest.count { it.passengers.contains(passenger) }
        withDiscount > withoutDiscount }.toSet() }
/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return trips.groupBy { t ->
        val start = t.duration / 10 * 10
        val end = start + 9
        start..end
    }.toList().maxByOrNull { it.second.size }?.first
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    return if(this.trips.isEmpty()) {
        false
    } else {
        val totalCost = this.trips.sumOf { it.cost }
        val incomeSortedDrivers = trips.groupBy { it.driver }
            .mapValues { (_, tripsDriver) -> tripsDriver.sumByDouble { it.cost }}
            .toList()
            .sortedByDescending { (_, value) -> value}
            .toMap()
        var currentSum = 0.0
        var drivers = 0
        for (value in incomeSortedDrivers.values){
            drivers++
            currentSum += value
            if (currentSum >= (totalCost * 0.8)) break
        }
        drivers <= (allDrivers.size * 0.2)
    }
}

// -------------------------- TEST METHODS
//private fun testFakeDrivers(fakeDriverIndexes: Set<Int>, tp: TaxiPark) {
//    val message = "Wrong result for 'findFakeDrivers()'."
//    val expected = fakeDriverIndexes.map { driver(it) }.toSet()
//    Assert.assertEquals(message, expected, tp.findFakeDrivers())
//}
//fun test0() = testFakeDrivers(setOf(0, 1, 2), taxiPark(0..2, 0..4))
//fun driver(i: Int) = Driver("D-$i")
//fun passenger(i: Int) = Passenger("P-$i")
//fun drivers(indices: List<Int>) = indices.map(::driver).toSet()
//fun drivers(range: IntRange) = drivers(range.toList())
//fun drivers(vararg indices: Int) = drivers(indices.toList())
//fun passengers(indices: List<Int>) = indices.map(::passenger).toSet()
//fun passengers(range: IntRange) = passengers(range.toList())
//fun passengers(vararg indices: Int) = passengers(indices.toList())
//fun trip(driverIndex: Int, passengerIndexes: List<Int>, duration: Int = 10, distance: Double = 3.0, discount: Double? = null) =
//    Trip(taxiPark.tests.driver(driverIndex), taxiPark.tests.passengers(passengerIndexes), duration, distance, discount)
//fun trip(driverIndex: Int, passenger: Int, duration: Int = 10, distance: Double = 3.0, discount: Double? = null) =
//    Trip(taxiPark.tests.driver(driverIndex), taxiPark.tests.passengers(passenger), duration, distance, discount)
//fun taxiPark(driverIndexes: IntRange, passengerIndexes: IntRange, vararg trips: Trip) =
//    TaxiPark(drivers(driverIndexes), passengers(passengerIndexes), trips.toList())
// TEST METHODS --------------------------

//fun setOfDrivers() = setOf<Driver>(Driver("A"), Driver("B"), Driver("C"))
//fun setOfPassengers() = setOf<Passenger>(Passenger("Z"), Passenger("Y"), Passenger("X"))
//fun listTrip(){}

fun testTaxiPark(){
    val dr1 = Driver("A")
    val dr2 = Driver("B")
    val dr3 = Driver("C")
    val dr4 = Driver("D")

    val ps1 = Passenger("Z")
    val ps2 = Passenger("Y")
    val ps3 = Passenger("X")
    val ps4 = Passenger("W")
    val ps5 = Passenger("V")
    val ps6 = Passenger("U")

    val tr1 = Trip(dr2, setOf(ps1, ps3), 3, 10.0)
    val tr2 = Trip(dr2, setOf(ps4), 1, 4.0)
    val tr3 = Trip(dr3, setOf(ps1, ps5, ps4), 10, 100.0)
    val tr4 = Trip(dr4, setOf(ps1, ps6), 23, 40.0)
    val tr5 = Trip(dr3, setOf(ps1), 28, 80.0, 40.0)

    val setDrivers = setOf<Driver>(dr1, dr2, dr3, dr4)
    val setPassengers = setOf<Passenger>(ps1, ps2, ps3, ps4, ps5, ps6)

    val listTrip = listOf<Trip>(
        tr1, tr2, tr3, tr4, tr5
    )

    val tp = TaxiPark(setDrivers, setPassengers, listTrip)
//    val tpAllDrivers = tp.allDrivers
//    for (i in tpAllDrivers){
//        println(i)
//    }
//    println(tp.allPassengers.size)
//    val tpFakeDrivers = tp.findFakeDrivers()
//    for (i in tpFakeDrivers){
//        println(i)
//    }
//    val tpFaithfulPassengers = tp.findFaithfulPassengers(2)
//    for (i in tpFaithfulPassengers){
//        println(i)
//    }
//    val tpFrequentPassengers = tp.findFrequentPassengers(dr1)
//    for (i in tpFrequentPassengers){
//        println(i)
//    }
//    val tpSmartPassengers = tp.findSmartPassengers()
//    for (i in tpSmartPassengers){
//        println(i)
//    }
    val tpTheMostFrequentTripDurationPeriod = tp.findTheMostFrequentTripDurationPeriod()
    println(tpTheMostFrequentTripDurationPeriod)
}

fun main(){
    testTaxiPark()
}