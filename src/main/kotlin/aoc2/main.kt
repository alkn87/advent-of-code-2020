package aoc2

import java.io.File

fun main () {
    val dataList = readFileAsLinesUsingUseLines("src/main/resources/dataInput_2.txt")
    var counter = 0
    var counter2 = 0
    dataList.forEach{
        val min = regGetMin(it)
        val max = regGetMax(it)
        val character = regGetChar(it)
        val password = regGetPass(it)
        if(getCharacterOccurrence(password, character) in min..max) {
            counter++
        }
        if(validateCharPositions(it, character)) counter2++
    }
    println(counter) // Result Puzzle 1
    println(counter2) // Result Puzzle 2
}

fun readFileAsLinesUsingUseLines(fileName: String): List<String>
        = File(fileName).useLines { it.toList() }

fun getCharacterOccurrence(s: String, c: Char): Int {
    return s.filter { it == c }.count()

}

// Regex Approach
// Puzzle 1

fun regGetMin(text: String): Int {
    val results = Regex("""\d+""").findAll(text)
    return results.first().value.toInt()
}

fun regGetMax(text: String): Int {
    val results = Regex("""\d+""").findAll(text)
    return results.last().value.toInt()
}

fun regGetChar(text: String): Char {
    val results = Regex(""".:""").findAll(text)
    return results.first().value.toCharArray().first()
}

fun regGetPass(text: String): String {
    val results = Regex("""(?<=: )(\w+)""").findAll(text)
    return results.first().value
}

// Puzzles 2

fun validateCharPositions(text: String, character: Char): Boolean {
    val atMinPosition = regGetPass(text)[regGetMin(text) - 1] == character
    val atMaxPosition = regGetPass(text)[regGetMax(text) - 1] == character
    return atMinPosition.xor(atMaxPosition)
}
