
class ControllerTTT {

  var cell = Array.ofDim[Char](3, 3)
  var turn = 0
  var input: String = null

  //function to check if the input is valid or not
  def valid_input(in: String): Boolean = {
    if (in.length == 2)
      if (in.charAt(0) == '3' || in.charAt(0) == '2' || in.charAt(0) == '1')
      if (in.charAt(1) == 'a' || in.charAt(1) == 'b' || in.charAt(1) == 'c') return true
    return false
  }//end of function

    //function to convert the input to the actual index
    def InputToIndex(in: String) = {
      val index = new Array[Int](2)
      in.charAt(0) match {
        case '3' =>
          index(0) = 0

        case '2' =>
          index(0) = 1

        case '1' =>
          index(0) = 2

      }
      in.charAt(1) match {
        case 'a' =>
          index(1) = 0

        case 'b' =>
          index(1) = 1

        case 'c' =>
          index(1) = 2

      }
      index
    }

    //function to check if the cell is empty
    def valid_cell(index: Array[Int]): Boolean = {
      val i = index(0)
      val j = index(1)
      if (cell(i)(j) != 'X' && cell(i)(j) != 'O') return true
      false
    }
  }