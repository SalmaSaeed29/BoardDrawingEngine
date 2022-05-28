
class ControllerCh {

  val objD = new DrawerCh
  var turn = 0
  var input: String = null

  //function to check if the input is valid or not
  def valid_input(in: String): Boolean = {
    if (in.length == 4)
      if (in.charAt(0) == '8' || in.charAt(0) == '7' || in.charAt(0) == '6' || in.charAt(0) == '5' || in.charAt(0) == '4' || in.charAt(0) == '3' || in.charAt(0) == '2' || in.charAt(0) == '1') {
        if (in.charAt(1) == 'a' || in.charAt(1) == 'b' || in.charAt(1) == 'c' || in.charAt(1) == 'd' || in.charAt(1) == 'e' || in.charAt(1) == 'f' || in.charAt(1) == 'g' || in.charAt(1) == 'h') {
          if(in.charAt(2) == '8' || in.charAt(2) == '7' || in.charAt(2) == '6' || in.charAt(2) == '5' || in.charAt(2) == '4' || in.charAt(2) == '3' || in.charAt(2) == '2' || in.charAt(2) == '1') {
            if(in.charAt(3) == 'a' || in.charAt(3) == 'b' || in.charAt(3) == 'c' || in.charAt(3) == 'd' || in.charAt(3) == 'e' || in.charAt(3) == 'f' || in.charAt(3) == 'g' || in.charAt(3) == 'h') {
              return true
            }
          }
        }
      }
    return false
  }//end of function

  //function to convert the input to the actual index
  def InputToIndex(in: String) = {
    val index = new Array[Int](4)
    in.charAt(0) match {
      case '8' => index(0) = 0
      case '7' => index(0) = 1
      case '6' => index(0) = 2
      case '5' => index(0) = 3
      case '4' => index(0) = 4
      case '3' => index(0) = 5
      case '2' => index(0) = 6
      case '1' => index(0) = 7
    }
    in.charAt(1) match {
      case 'a' => index(1) = 0
      case 'b' => index(1) = 1
      case 'c' => index(1) = 2
      case 'd' => index(1) = 3
      case 'e' => index(1) = 4
      case 'f' => index(1) = 5
      case 'g' => index(1) = 6
      case 'h' => index(1) = 7
    }
    in.charAt(2) match {
      case '8' => index(2) = 0
      case '7' => index(2) = 1
      case '6' => index(2) = 2
      case '5' => index(2) = 3
      case '4' => index(2) = 4
      case '3' => index(2) = 5
      case '2' => index(2) = 6
      case '1' => index(2) = 7
    }
    in.charAt(3) match {
      case 'a' => index(3) = 0
      case 'b' => index(3) = 1
      case 'c' => index(3) = 2
      case 'd' => index(3) = 3
      case 'e' => index(3) = 4
      case 'f' => index(3) = 5
      case 'g' => index(3) = 6
      case 'h' => index(3) = 7
    }
    index
  }

}