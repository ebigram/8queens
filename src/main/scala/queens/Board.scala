package queens

/** Enumeration of the states of a cell -- either a cell is empty or it contains a queen. */
enum Cell:
  case Empty, Queen

/**
 * An m x n chess board.
 *
 * Each cell of the board is either `Empty` or it contains a `Queen`.
 * The board is represented as a 0-indexed collection of columns and
 * each column is represented as a 0-indexed collection of cells.
 *
 * The `toString` method prints a graphical representation of the board,
 * where the lower left corner is index (0, 0), the upper left corner is (0, 7),
 * the upper right corner is (7, 7), and the lower right corner is (7, 0).
 */
case class Board(columns: Vector[Vector[Cell]]):

  /** Returns the number of columns on this board. */
  def columnCount: Int = columns.size

  /** Returns the number of rows on this board. */
  def rowCount: Int = columns.head.size

  /** Gets the value of the specified cell. */
  def cell(columnNumber: Int, rowNumber: Int): Cell =
    columns(columnNumber)(rowNumber)

  /** Returns a new board with a queen placed at the specified column and row. */
  def placeQueen(columnNumber: Int, rowNumber: Int): Board =
    place(columnNumber, rowNumber, Cell.Queen)

  /** Sets the cell at the specified column and row to the supplied value. */
  private def place(columnNumber: Int, rowNumber: Int, cell: Cell): Board =
    val updatedRow = columns(columnNumber).updated(rowNumber, cell)
    Board(columns.updated(columnNumber, updatedRow))
 
  /** Returns true if the specified cell is empty. */
  def empty(columnNumber: Int, rowNumber: Int): Boolean =
    ???

  /** Provides a count of the number of queens placed on this board. */
  def queenCount: Int =
    ???

  /** Returns true if there are no queens on this board which can be captured. */
  def valid: Boolean =
    ???

  /** Returns true if there are no queens in the same column. */
  private def columnsValid: Boolean =
    ???

  /** Returns true if there are no queens in the same row. */
  private def rowsValid: Boolean =
    ???

  /** Returns true if there are no queens in the same diagonal. */
  private def diagonalsValid: Boolean =
    ???

  /** Returns a collection of all solutions that start with the current board. */
  def solutions: Iterable[Board] =
    ???

  override def toString: String =
    ((rowCount - 1) to 0 by -1).toList.map { rowNumber =>
      (0 until columnCount).map { columnNumber =>
        if empty(columnNumber, rowNumber) then "・" else "Q"
      }.mkString
    }.mkString("\n")

end Board

object Board:
  /** Makes a square board with `count` columns and rows. */
  def make(count: Int): Board = make(count, count)

  /** Makes a board with the specified number of columns and rows. */
  def make(columns: Int, rows: Int): Board =
    new Board(Vector.fill(columns)(Vector.fill(rows)(Cell.Empty)))

