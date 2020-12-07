package aoc4

import java.io.File

fun main() {
    val fileContent = readFileAsString("src/main/resources/dataInput_4.txt")
    val passportList = fileContent.split("\n\r")

    // Part 1

    val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid")
    val resultList = validateInputs(passportList, requiredFields)
    println(resultList.count { it })

    // Part 2
    println(validateInputsAndFields(passportList))

}

// Part 1

fun readFileAsString(fileName: String): String {
    return File(fileName).readText()
}

fun isFieldPresent(field: String, element: String): Boolean {
    // https://regexr.com/
    return Regex("(^|\\n| )($field:)").containsMatchIn(element)
}

fun validateInputs(elements: List<String>, requiredFields: List<String>): List<Boolean> {
    val list = mutableListOf<Boolean>()
    for (element in elements) {
        var validFields = 0
        for (field in requiredFields) {
            if (isFieldPresent(field, element)) validFields++
        }
        if (validFields > 7) list.add(true)
        else if (validFields == 7 && !isFieldPresent("cid", element)) list.add(true)
        else list.add(false)
    }
    return list.toList()
}

// Part 2

fun validateFieldByr(passport: String): Boolean {
    val regexResult = Regex("(?:^|\\n| )byr:(\\d{4})(?:$|\\n| |\\r)").findAll(passport)

    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-match-result/group-values.html
    if (regexResult.count() == 1 && regexResult.first().groupValues[1].toInt() in 1920..2002) {
        return true
    }
    return false
}

fun validateFieldIyr(passport: String): Boolean {
    val regexResult = Regex("(?:^|\\n| )iyr:(\\d{4})(?:$|\\n| |\\r)").findAll(passport)

    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-match-result/group-values.html
    if (regexResult.count() == 1 && regexResult.first().groupValues[1].toInt() in 2010..2020) {
        return true
    }
    return false
}

fun validateFieldEyr(passport: String): Boolean {
    val regexResult = Regex("(?:^|\\n| )eyr:(\\d{4})(?:$|\\n| |\\r)").findAll(passport)

    // https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-match-result/group-values.html
    if (regexResult.count() == 1 && regexResult.first().groupValues[1].toInt() in 2020..2030) {
        return true
    }
    return false
}

fun validateFieldHgt(passport: String): Boolean {
    val regexResult = Regex("(?:^|\\n| )hgt:(\\d{3})cm|(\\d{2})in(?:$|\\n| |\\r)")
        .findAll(passport)

    if(regexResult.count() == 1 && regexResult.first().groupValues[1].isNotBlank()) {
        return regexResult.first().groupValues[1].toInt() in 150..193
    }

    if(regexResult.count() == 1 && regexResult.first().groupValues[2].isNotBlank()) {
        return regexResult.first().groupValues[2].toInt() in 59..76
    }

    return false
}

fun validateFieldHcl(passport: String): Boolean {
    return Regex("(?:^|\\n| )hcl:#[0-9a-f]{6}(?:$|\\n| |\\r)").containsMatchIn(passport)
}

fun validateFieldEcl(passport: String): Boolean {
    return Regex("(?:^|\\n| )ecl:(?:amb|blu|brn|gry|grn|hzl|oth)(?:$|\\n| |\\r)")
        .containsMatchIn(passport)
}

fun validateFieldPid(passport: String): Boolean {
    return Regex("(?:^|\\n| )pid:[0-9]{9}(?:$|\\n| |\\r)")
        .containsMatchIn(passport)
}

fun validateInputsAndFields(passportList: List<String>): Int {
    var countValid = 0
    for (passport in passportList) {
        if (    validateFieldByr(passport) &&
                validateFieldIyr(passport) &&
                validateFieldEyr(passport) &&
                validateFieldHgt(passport) &&
                validateFieldHcl(passport) &&
                validateFieldEcl(passport) &&
                validateFieldPid(passport)) {
            countValid++
        }
    }
    return countValid
}
