package niceString

const val VOWELS = "aeiou"

fun String.isNice(): Boolean {
      return conditionOne(this) &&
              (conditionTwo(this) || conditionThree(this)) ||
              (conditionTwo(this) && conditionThree(this))
}

fun conditionOne(str: String) : Boolean{
    return !(str.contains("bu") || str.contains("ba") || str.contains("be"))
}
fun conditionTwo(str: String) : Boolean{
    var count = 0
    for (i in VOWELS.indices) {
        val tCount = str.count { it == VOWELS[i] }
        count += tCount
    }
    return count >= 3
}
fun conditionThree(str: String) : Boolean{
    var r = false
    for (i in str.indicesCustom) {
        r = str[i] == str[i+1]
        if (r) break
    }
    return r
}

private val CharSequence.indicesCustom: IntRange
    get() = 0..length - 2