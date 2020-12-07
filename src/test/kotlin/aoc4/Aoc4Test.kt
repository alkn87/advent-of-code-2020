package aoc4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Aoc4Test {

    // Part 1

    val testFile = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
            "byr:1937 iyr:2017 cid:147 hgt:183cm\n" +
            "\n" +
            "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
            "hcl:#cfa07d byr:1929\n" +
            "\n" +
            "hcl:#ae17e1 iyr:2013\n" +
            "eyr:2024\n" +
            "ecl:brn pid:760753108 byr:1931\n" +
            "hgt:179cm\n" +
            "\n" +
            "hcl:#cfa07d eyr:2025 pid:166559648\n" +
            "iyr:2011 ecl:brn hgt:59in"

    @Test
    fun shouldSplitFileContentAtNewLine() {
        assertEquals(4, testFile.split("\n\n").size)
    }

    @Test
    fun shouldIndicateExistingField() {
        val firstElement = testFile.split("\n\n")[0]
        assertEquals(true, isFieldPresent("ecl", firstElement))
    }

    @Test
    fun shouldValidateElement() {
        val elements = testFile.split("\n\n")
        val requiredFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid")
        assertEquals(listOf(true, false, true, false), validateInputs(elements, requiredFields))
    }

    // Part 2

    @Test
    fun shouldValidate_Byr() {
        val fieldValid = "abc:554 byr:1921 xyz:123"
        val fieldInvalidHigh = "abc:554 byr:2003 xyz:123"
        val fieldInvalidLow = "byr:1919"
        val fieldInvalidMissing = "abc:554 cid:1987 xyz:123"

        assertEquals(true, validateFieldByr(fieldValid))
        assertEquals(false, validateFieldByr(fieldInvalidHigh))
        assertEquals(false, validateFieldByr(fieldInvalidLow))
        assertEquals(false, validateFieldByr(fieldInvalidMissing))
    }

    @Test
    fun shouldValidate_Iyr() {
        val fieldValid = "abc:554 iyr:2011 xyz:123"
        val fieldInvalidHigh = "abc:554 iyr:2021 xyz:123"
        val fieldInvalidLow = "iyr:2009"
        val fieldInvalidMissing = "abc:554 cid:1987 xyz:123"

        assertEquals(true, validateFieldIyr(fieldValid))
        assertEquals(false, validateFieldIyr(fieldInvalidHigh))
        assertEquals(false, validateFieldIyr(fieldInvalidLow))
        assertEquals(false, validateFieldIyr(fieldInvalidMissing))
    }

    @Test
    fun shouldValidate_Eyr() {
        val fieldValid = "abc:554 eyr:2021 xyz:123"
        val fieldInvalidHigh = "abc:554 eyr:2031 xyz:123"
        val fieldInvalidLow = "eyr:2019"
        val fieldInvalidMissing = "abc:554 cid:1987 xyz:123"

        assertEquals(true, validateFieldEyr(fieldValid))
        assertEquals(false, validateFieldEyr(fieldInvalidHigh))
        assertEquals(false, validateFieldEyr(fieldInvalidLow))
        assertEquals(false, validateFieldEyr(fieldInvalidMissing))
    }

    @Test
    fun shouldValidate_Hgt() {
        val fieldValidCm = "abc:554 hgt:164cm xyz:123"
        val fieldInvalidCmHigh = "abc:554 hgt:194cm xyz:123"
        val fieldInvalidCmLow = "abc:554 hgt:194cm xyz:123"
        val fieldValidIn = "abc:554 hgt:60in xyz:123"
        val fieldInvalidInHigh = "abc:554 hgt:77in xyz:123"
        val fieldInvalidInLow = "abc:554 hgt:58in xyz:123"
        val fieldInvalidMissing = "abc:554 xyz:123"

        assertEquals(true, validateFieldHgt(fieldValidCm))
        assertEquals(false, validateFieldHgt(fieldInvalidCmHigh))
        assertEquals(false, validateFieldHgt(fieldInvalidCmLow))
        assertEquals(true, validateFieldHgt(fieldValidIn))
        assertEquals(false, validateFieldHgt(fieldInvalidInHigh))
        assertEquals(false, validateFieldHgt(fieldInvalidInLow))
        assertEquals(false, validateFieldHgt(fieldInvalidMissing))
    }

    @Test
    fun shouldValidate_Hcl() {
        val fieldValid = "iyr:2019 hcl:#602ab3 eyr:1967"
        val fieldInvalid1 = "iyr:2019 hcl:#602az3 eyr:1967"
        val fieldInvalid2 = "iyr:2019 hcl:#60ab3 eyr:1967"
        val fieldInvalidMissing = "iyr:2019 eyr:1967"

        assertEquals(true, validateFieldHcl(fieldValid))
        assertEquals(false, validateFieldHcl(fieldInvalid1))
        assertEquals(false, validateFieldHcl(fieldInvalid2))
        assertEquals(false, validateFieldHcl(fieldInvalidMissing))
    }

    @Test
    fun shouldValidate_Ecl() {
        val fieldValid1 = "iyr:2019 ecl:amb eyr:1967"
        val fieldValid2 = "iyr:2019 ecl:brn eyr:1967"
        val fieldInvalid = "iyr:2019 ecl:zzz eyr:1967"
        val fieldInvalidMissing = "iyr:2019 eyr:1967"

        assertEquals(true, validateFieldEcl(fieldValid1))
        assertEquals(true, validateFieldEcl(fieldValid2))
        assertEquals(false, validateFieldEcl(fieldInvalid))
        assertEquals(false, validateFieldEcl(fieldInvalidMissing))
    }

    @Test
    fun shouldValidate_Pid() {
        val fieldValid = "ecl:grn pid:012345678 byr:1946"
        val fieldInvalid = "ecl:grn pid:0123456789 byr:1946"

        assertEquals(true, validateFieldPid(fieldValid))
        assertEquals(false, validateFieldPid(fieldInvalid))
    }

    @Test
    fun shouldValidateInputsAndFields() {
        val validInput = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\n" +
                "hcl:#623a2f\n" +
                "\n" +
                "eyr:2029 ecl:blu cid:129 byr:1989\n" +
                "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm\n" +
                "\n" +
                "hcl:#888785\n" +
                "hgt:164cm byr:2001 iyr:2015 cid:88\n" +
                "pid:545766238 ecl:hzl\n" +
                "eyr:2022\n" +
                "\n" +
                "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719"
        val validPassports = validInput.split("\n\n")


        val invalidInput = "eyr:1972 cid:100\n" +
                "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926\n" +
                "\n" +
                "iyr:2019\n" +
                "hcl:#602927 eyr:1967 hgt:170cm\n" +
                "ecl:grn pid:012533040 byr:1946\n" +
                "\n" +
                "hcl:dab227 iyr:2012\n" +
                "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277\n" +
                "\n" +
                "hgt:59cm ecl:zzz\n" +
                "eyr:2038 hcl:74454a iyr:2023\n" +
                "pid:3556412378 byr:2007"
        val invalidPassports = invalidInput.split("\n\n")

        assertEquals(4, validateInputsAndFields(validPassports))
        assertEquals(0, validateInputsAndFields(invalidPassports))
    }
}
