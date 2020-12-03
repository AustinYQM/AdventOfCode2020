import java.io.File
import java.lang.Exception
import java.util.*

object DayTwo {
    @JvmStatic
    fun main(args: Array<String>) {
        partOne("day2")
        partTwo("day2")
    }

    fun partOne(fileName: String?) {
        println("::::: Part One :::::")
        var passCount = 0
        try {
            val file = Scanner(File(fileName))
            while (file.hasNextLine()) {
                val line = file.nextLine()
                val (min, max) = buildMinMax(line)
                val letter = buildChar(line)
                val pass = buildString(line)
                val count = letterCount(pass, letter)
                val correct = countInRange(min, max, count)
                println(letter.toString() + " appears " + count + " times which is " +
                        (if (correct) "inside" else "outside") + " the range of " + min + "..." + max)
                if (correct) passCount++
            }
            println("Total number of correct passwords: $passCount")
            println()
        } catch (e: Exception) {
            println(e)
        }
    }

    fun partTwo(fileName: String?) {
        println("::::: Part Two :::::")
        var passCount = 0
        try {
            val file = Scanner(File(fileName))
            while (file.hasNextLine()) {
                val line = file.nextLine()
                val (pos1, pos2) = buildMinMax(line)
                val letter = buildChar(line)
                val pass = buildString(line)
                val correct = checkPass(pass, pos1, pos2, letter)
                println("Target letter (" + letter + ") " + (if (correct) "was" else "wasn't") + " found at exactly one of the given (" +
                        pos1 + ", " + pos2 + ") positions in the password " + pass + ". Password is " + (if (correct) "valid" else "invalid") + ".")
                if (correct) passCount++
            }
            println("Total number of correct passwords: $passCount")
            println()
        } catch (e: Exception) {
            println(e)
        }
    }

    fun letterCount(pass: String, letter: Char) = pass.filter { it == letter }.count()

    fun countInRange(min: Int, max: Int, count: Int)  = count in min..max

    fun buildMin(line: String) =  line.substring(0, line.indexOf('-')).toInt()

    fun buildMax(line: String) = line.substring(line.indexOf('-') + 1, line.indexOf(' ')).toInt()

    fun buildChar(line: String) = line[line.indexOf(':')-1]

    fun buildString(line: String) = line.substring(line.indexOf(' ', line.indexOf(' ') + 1) + 1)

    fun buildMinMax(line: String): Pair<Int, Int> = Pair(buildMin(line), buildMax(line))




    fun checkPass(pass: String,
                  pos1: Int,
                  pos2: Int,
                  letter: Char): Boolean =  (pass[pos1 - 1] == letter) xor (pass[pos2 - 1] == letter)

}