fun main() {
    fun part1(input: List<String>): Int {
        var res = 0
        // Horizontal
        for (i in input.indices) {
            for (j in 0..input[i].length - 4) {
                val string = input[i].substring(j, j + 4)
                if (string == "XMAS" || string == "SAMX") res++
            }
        }
        // Vertical
        for (i in 0..input.size - 4) {
            for (j in 0..input[i].lastIndex) {
                val string = listOf(input[i][j], input[i + 1][j], input[i + 2][j], input[i + 3][j]).joinToString("")
                if (string == "XMAS" || string == "SAMX") res++
            }
        }
        // Diagonal
        for (i in 0..input.size - 4) {
            for (j in 0..input[i].length - 4) {
                val string1 = listOf(input[i][j], input[i + 1][j + 1], input[i + 2][j + 2], input[i + 3][j + 3]).joinToString("")
                if (string1 == "XMAS" || string1 == "SAMX") res++
                val string2 = listOf(input[i + 3][j], input[i + 2][j + 1], input[i + 1][j + 2], input[i][j + 3]).joinToString("")
                if (string2 == "XMAS" || string2 == "SAMX") res++
            }
        }
        return res
    }

    fun part2(input: List<String>): Int {
        var res = 0
        for (i in 0..input.size - 3) {
            for (j in 0..input[i].length - 3) {
                if (input[i + 1][j + 1] == 'A') {
                    val string = listOf(input[i][j], input[i][j + 2], input[i + 2][j], input[i + 2][j + 2]).joinToString("")
                    if (string == "MMSS" || string == "SSMM" || string == "MSMS" || string == "SMSM") res++
                }
            }
        }
        return res
    }

    fun parseInput(input: List<String>): List<String> {
        return input
    }

    val testInput = parseInput(readInput("Day04_test"))
    check(part1(testInput) == 18)
    check(part2(testInput) == 9)

    val input = parseInput(readInput("Day04"))
    part1(input).println()
    part2(input).println()
}
