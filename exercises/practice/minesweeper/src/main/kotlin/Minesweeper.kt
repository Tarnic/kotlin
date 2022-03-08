data class MinesweeperBoard(val inputBoard: List<String>) {

    fun withNumbers(): List<String> {
        // TODO("Implement this function to complete the task")

        return inputBoard.mapIndexed { row, str -> 
            str.mapIndexed { col, el -> when(el) {
                    ' ' -> checkAdjacentMines(row, col)
                    else -> el
                } 
            }.joinToString("")
        }
    }

    fun checkAdjacentMines(row: Int, col: Int): Char {
        val cols = Math.max(row-1, 0)..Math.min(row+1, inputBoard.size-1)
        
        val count = cols.flatMap { i ->
            (Math.max(col-1, 0)..Math.min(col+1, inputBoard[i].length-1)).map { j -> 
                if(inputBoard[i][j] == '*') 1 else 0
            }
        }.sum()

        return if (count > 0) (count + 48).toChar() else ' '
    }
}
