
fun main() {
    val runner = DayFive();
    runner.partOne("day5")
    runner.partTwo("day5")
}

class DayFive {

    fun partOne(fileName: String) {
        val ourPasses = Helper.returnStrings(fileName)
        val highest = ourPasses.max()
        println("The highest seat value is: $highest.")
    }

    fun partTwo(fileName: String) {
        val ourPasses = Helper.returnStrings(fileName)
        val ourSeatIds = mutableListOf<Int>()
        ourPasses.forEach { ourSeatIds.add(findSeatId(it)) }
        val ifNonMissingSum = (checkNotNull(ourSeatIds.minOrNull())..checkNotNull(ourSeatIds.maxOrNull())).toList().sum()
        val missOurSeatSum = ourSeatIds.sum()
        val answer = ifNonMissingSum - missOurSeatSum

        println("Our seat ID is: $answer." )
    }

    fun findRow(aPass: String): Int {
        var rowFinder = aPass.substring(0..6);
        var minRow = 0;
        var maxRow = 127;
        rowFinder.forEach {
            if (it == 'F') maxRow -= Math.ceil(((maxRow - minRow) / 2f).toDouble()).toInt()
            if (it == 'B') minRow += Math.ceil(((maxRow - minRow) / 2f).toDouble()).toInt()
        }
        return if(aPass[7] == 'F') minRow else maxRow;
    }

    fun findColumn(aPass: String): Int {
        var columnFinder = aPass.substring(7..9);
        var minCol = 0;
        var maxCol = 7;
        columnFinder.forEach {
            if (it == 'L') maxCol -= Math.ceil(((maxCol - minCol) / 2f).toDouble()).toInt()
            if (it == 'R') minCol += Math.ceil(((maxCol - minCol) / 2f).toDouble()).toInt()
        }
        return if(aPass[9] == 'L') minCol else maxCol;
    }

    fun findSeatId(aPass: String) = findRow(aPass) * 8 + findColumn(aPass)
}

