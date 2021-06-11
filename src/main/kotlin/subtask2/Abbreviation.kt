package subtask2

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        var length = b.length
        var currentIndex = 0
        for (i in b.indices) {
            for (innerIndex in currentIndex until  a.length) {
                if (b[i] == a[innerIndex].toUpperCase()) {
                    length--
                    currentIndex = innerIndex + 1
                    break
                }
                if (a[innerIndex].isUpperCase()) {
                    return "NO"
                }
            }
        }

        return when(length) {
            0 -> "YES"
            else -> "NO"
        }
    }
}
