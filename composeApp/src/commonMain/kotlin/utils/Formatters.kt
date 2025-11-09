package utils

import kotlin.math.pow
import kotlin.math.roundToInt

fun Double.formatDecimal(digits: Int): String {
    val factor = 10.0.pow(digits)
    return ((this * factor).roundToInt() / factor).toString()
}