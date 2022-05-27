import java.awt.Color
import java.awt.Graphics
import javax.swing.JFrame
import javax.swing.JPanel

object Engine {
  def main(args: Array[String]): Unit = {

   val frame = new JFrame
   frame.setSize(600, 600)
   frame.setTitle("Checkers Board")
   frame.getContentPane.add(new CheckersBoard)
   frame.setLocationRelativeTo(null)
   frame.setBackground(Color.LIGHT_GRAY)
   frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE)
   frame.setVisible(true)
  }


}
