package com.sawrose.eatelicious.feature.color.utils

import kotlin.math.abs

/** Utility methods for mathematical operations. */
object MathUtils {
    /**
     * The signum function.
     *
     * @return 1 if num > 0, -1 if num < 0, and 0 if num = 0
     */
    fun signum(num: Double): Int {
        return if (num < 0) {
            -1
        } else if (num == 0.0) {
            0
        } else {
            1
        }
    }

    /**
     * The linear interpolation function.
     *
     * @return start if amount = 0 and stop if amount = 1
     */
    fun lerp(start: Double, stop: Double, amount: Double): Double {
        return (1.0 - amount) * start + amount * stop
    }

    /**
     * Clamps an integer between two integers.
     *
     * @return input when min <= input <= max, and either min or max otherwise.
     */
    fun clampInt(min: Int, max: Int, input: Int): Int {
        if (input < min) {
            return min
        } else if (input > max) {
            return max
        }
        return input
    }

    /**
     * Clamps an integer between two floating-point numbers.
     *
     * @return input when min <= input <= max, and either min or max otherwise.
     */
    fun clampDouble(min: Double, max: Double, input: Double): Double {
        if (input < min) {
            return min
        } else if (input > max) {
            return max
        }
        return input
    }

    /**
     * Sanitizes a degree measure as a floating-point number.
     *
     * @return a degree measure between 0.0 (inclusive) and 360.0 (exclusive).
     */
    fun sanitizeDegreesDouble(degrees: Double): Double {
        var degrees = degrees
        degrees %= 360.0
        if (degrees < 0) {
            degrees += 360.0
        }
        return degrees
    }

    /**
     * Sign of direction change needed to travel from one angle to another.
     *
     *
     * For angles that are 180 degrees apart from each other, both directions have the same travel
     * distance, so either direction is shortest. The value 1.0 is returned in this case.
     *
     * @param from The angle travel starts from, in degrees.
     * @param to The angle travel ends at, in degrees.
     * @return -1 if decreasing from leads to the shortest travel distance, 1 if increasing from leads
     * to the shortest travel distance.
     */
    fun rotationDirection(from: Double, to: Double): Double {
        val increasingDifference = sanitizeDegreesDouble(to - from)
        return if (increasingDifference <= 180.0) 1.0 else -1.0
    }

    /** Distance of two points on a circle, represented using degrees.  */
    fun differenceDegrees(a: Double, b: Double): Double {
        return 180.0 - abs(abs(a - b) - 180.0)
    }

    /** Multiplies a 1x3 row vector with a 3x3 matrix.  */
    fun matrixMultiply(row: DoubleArray, matrix: Array<DoubleArray>): DoubleArray {
        val a = row[0] * matrix[0][0] + row[1] * matrix[0][1] + row[2] * matrix[0][2]
        val b = row[0] * matrix[1][0] + row[1] * matrix[1][1] + row[2] * matrix[1][2]
        val c = row[0] * matrix[2][0] + row[1] * matrix[2][1] + row[2] * matrix[2][2]
        return doubleArrayOf(a, b, c)
    }

    fun toDegrees(angrad: Double): Double {
        return angrad * 57.29577951308232
    }

    fun toRadians(angdeg: Double): Double {
        return angdeg * 0.017453292519943295
    }
}
