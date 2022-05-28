import java.awt.event.ActionEvent
import javax.swing.{AbstractAction, JLabel, JPanel}

object mainCh {
  def main(args: Array[String]): Unit = {

    val objD = new DrawerCh
    objD.initialize()
    val objC = new ControllerCh
    objC.turn = 0    //DARK grey turn => 0, LIGHT grey turn => 1
    var flag = false //to determine if the input is valid or not

    objD.printDcell()

    val action = new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit = {
        objC.input = objD.box.getText //input
        println(objC.input)

        if(!objC.valid_input(objC.input)){
          println("invalid input")
          flag = true
        }
        else {
          val arr = objC.InputToIndex(objC.input) //index
          if (objD.valid_cell(objC.turn, arr) && objD.jump == false) {
            flag = false
            if (objC.turn == 0) {                 //DARK grey turn
              objD.draw_circle(0, arr(2), arr(3))
              objC.turn = 1
            }
            else {                               //LIGHT grey turn
              objD.draw_circle(1, arr(2), arr(3))
              objC.turn = 0
            }
            objD.delete_circle(arr(0), arr(1))
          }

          else if(objD.valid_cell(objC.turn, arr) && objD.jump == true){
            println("jumpppppp")
            flag = false
            if (objC.turn == 0) {                 //DARK grey turn
              if(arr(3) > arr(1)){    //jump right
                println("jump right")
                objD.delete_circle(arr(0)-1, arr(1)+1) //delete the jump over
              }
              else{                   //jump left
                println("jump left")
                objD.delete_circle(arr(0)-1, arr(1)-1) //delete the jump over
              }
              objD.draw_circle(0, arr(2), arr(3))
              objC.turn = 1
            }

            else {                               //LIGHT grey turn
              if(arr(3) > arr(1)){    //jump right
                println("jump right")
                objD.delete_circle(arr(0)+1, arr(1)+1) //delete the jump over
              }
              else{                   //jump left
                println("jump left")
                objD.delete_circle(arr(0)+1, arr(1)-1) //delete the jump over
              }
              objD.draw_circle(1, arr(2), arr(3))
              objC.turn = 0
            }
            objD.delete_circle(arr(0), arr(1))
          }
          else {
            println("not valid cell")
            flag = true;
          }
        }
        objD.wtiteInGuide(objC.turn, flag)
        objD.box.setText("")
      }
    }
    objD.box.addActionListener(action)
  }
}

