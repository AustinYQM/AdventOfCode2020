import java.io.File
import java.util.*

object Helper {
    fun returnInts(fileName: String?): MutableList<Int> {
        val list: MutableList<Int> = ArrayList<Int>()
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

    fun returnStrings(fileName: String?): MutableList<String> {
        val list: MutableList<String> = ArrayList<String>()
        try {
            val file = Scanner(File(fileName))
            while (file.hasNextLine()) {
                list.add(file.nextLine() as String)
            }
        } catch (e: java.lang.Exception) {
            println(e)
        }
        return list
    }
}