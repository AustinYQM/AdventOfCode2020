import java.io.File
import java.util.*

object Helper {
    fun returnInts(fileName: String?): MutableList<Int> {
        val list: MutableList<Int> = LinkedList<Int>()
        try {
            val file = Scanner(File(fileName))
            while (file.hasNextInt()) {
                list.add(file.nextInt())
            }
        } catch (e: Exception) {
            println(e.stackTrace)
        }
        return list
    }
}