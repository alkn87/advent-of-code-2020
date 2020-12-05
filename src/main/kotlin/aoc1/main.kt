package aoc1

import java.io.File

fun main() {
    val dataList = readFileAsLinesUsingUseLines("src/main/resources/dataInput_1.txt")
    val numberList = mutableListOf<Int>()
    dataList.forEach { numberList.add(it.toInt()) }
    val resultPair = sumsToTarget(numberList.toIntArray(), 2020)
    println(resultPair)
    println(multiplyList(resultPair))
    val resultTriplet = sums3ToTarget(numberList.toIntArray(), 2020)
    println(resultTriplet)
    println(multiplyList(resultTriplet))
}

fun readFileAsLinesUsingUseLines(fileName: String): List<String>
        = File(fileName).useLines { it.toList() }

fun multiplyList(arr: List<Int>): Int {
    return arr.reduce { acc, i -> acc * i }
}

fun sumsToTarget(arr: IntArray, k: Int): List<Int> {
    val values: HashSet<Int> = HashSet()
    for (i in arr.indices) {
        if (values.contains(k-arr[i])) return intArrayOf(arr[i], k-arr[i]).sortedArray().asList()
        values.add(arr[i])
    }
    return intArrayOf().asList()
}

fun sums3ToTarget(arr: IntArray, k: Int): List<Int> {
    val values: HashSet<Int> = HashSet()
    for (i in arr.indices) {
        for (j in i until arr.size) {
            if (values.contains(k-arr[i]-arr[j]) && arrayListOf(arr[i], k - arr[i] - arr[j], arr[j]).toSet().size == 3) {
                return intArrayOf(arr[i], k - arr[i] - arr[j], arr[j]).sortedArray().asList()
            }
            values.add(arr[j])
        }
        values.add(arr[i])
    }
    return intArrayOf().asList()
}

