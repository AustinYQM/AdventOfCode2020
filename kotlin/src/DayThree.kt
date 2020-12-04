import java.io.File
import java.lang.Exception
import java.util.*

object DayThree {
    @JvmStatic
    fun main(args: Array<String>) {
        partOne("day3")
        partTwo("day3")
    }

    fun partOne(filename: String?) {
        println(countTrees(filename,3,1))
    }

    fun countTrees(filename: String?, rslope: Int, dslope: Int): Int {
        try {
            val file = Scanner(File(filename))
            var position = rslope
            var treeCount = 0
            var downSlope = dslope
            var row = file.nextLine()
            while (file.hasNextLine()) {
                while (--downSlope > 0) row = file.nextLine()
                row = file.nextLine()
                if (position >= row.length) position -= row.length
                if (row[position] == '#') {
                    treeCount++
                }
                position += rslope
                downSlope = dslope
            }
            return treeCount
        } catch (e: Exception) {
            println(e)
        }
        return 0
    }

    fun partTwo(filename: String?) {
        var totalTrees = 1
        totalTrees *= countTrees(filename, 1, 1)
        println(countTrees(filename, 1, 1))
        totalTrees *= countTrees(filename, 3, 1)
        println(countTrees(filename, 3, 1))
        totalTrees *= countTrees(filename, 5, 1)
        println(countTrees(filename, 5, 1))
        totalTrees *= countTrees(filename, 7, 1)
        println(countTrees(filename, 7, 1))
        totalTrees *= countTrees(filename, 1, 2)
        println(countTrees(filename, 1, 2))
        println("Total trees: $totalTrees")
    }
}