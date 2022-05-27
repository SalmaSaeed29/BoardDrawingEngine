import javax.swing._
import java.awt._

class DrawerTTT extends JFrame {
  var frame = new JFrame                          //create a frame
  var panel = Array.ofDim[JPanel](3, 3)  //cells
  var nonoPanels = new Array[JPanel](12)          //to put numbers and letters
  var nonoLabels = new Array[JLabel](12)          //numbers and letters
  var boxContainer = new JPanel                   //input
  var box = new JTextField
  var guideBox = new JPanel                       //guide box
  var guideText = new JTextField

  def drawFrame(): Unit = {
    frame.setTitle("Tic Tac Toe!")
    frame.setSize(480 + 15 + 30, 480 + 39 + 30 + 80) //frame size

    //frame.setResizable(false);
    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE)
    frame.getContentPane.setBackground(Color.yellow)
    frame.setLayout(null)
    frame.setVisible(true) //make frame visible

    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    //create the cells
    var x = 15
    var y = 15
    for (i <- 0 until 3) {
      for (j <- 0 until 3) {
        panel(i)(j) = new JPanel
        panel(i)(j).setBackground(Color.BLACK)
        panel(i)(j).setBounds(x, y, 150, 150)
        frame.add(panel(i)(j))
        x += 165
      }
      x = 15
      y += 165
    }
    /*create numbers of cells inside
    * display numbers from 3 to 1 in right and left
    */
    var xnono = 0
    var ynono = 15
    var num = 0
    var cellNum = 3
    for (i <- 0 until 6) {
      nonoPanels(i) = new JPanel
      nonoLabels(i) = new JLabel
      nonoPanels(i).setBackground(Color.WHITE)
      nonoPanels(i).setBounds(xnono, ynono, 15, 150)
      nonoLabels(i).setText(String.valueOf({
        cellNum -= 1; cellNum + 1
      }))
      nonoPanels(i).setLayout(new GridBagLayout)
      nonoPanels(i).add(nonoLabels(i))
      frame.add(nonoPanels(i))
      ynono += 15 + 150
      num += 1
      if (num == 3) {
        xnono = 495
        ynono = 15
        cellNum = 3
      }
    }
    /*
     * display letters from a to c up and down
     */ xnono = 15
    ynono = 0
    var cellLet = 'a'
    for (i <- 6 until 12) {
      nonoPanels(i) = new JPanel
      nonoLabels(i) = new JLabel
      nonoPanels(i).setBackground(Color.WHITE)
      nonoPanels(i).setBounds(xnono, ynono, 150, 15)
      nonoLabels(i).setText(String.valueOf({
        cellLet
      }))
      cellLet = ((cellLet+1).toInt).toChar
      nonoPanels(i).setLayout(new GridBagLayout)
      nonoPanels(i).add(nonoLabels(i))
      frame.add(nonoPanels(i))
      xnono += 15 + 150
      num += 1
      if (num == 9) {
        ynono = 495
        xnono = 15
        cellLet = 'a'
      }
    }
    frame.setVisible(true)
  }

//draw the box of text field
  def drawBox(): Unit = {
    boxContainer.setBounds(0, 480 + 20 + 30, 100, 50)
    boxContainer.setBackground(Color.BLACK)
    box.setPreferredSize(new Dimension(80, 40))
    boxContainer.add(box)
    frame.add(boxContainer)
    frame.setVisible(true)
  }//end of function

  //draw a box to display the turn
  def guide(): Unit ={
    guideBox.setBounds(120, 480 + 20 + 30, 150, 50)
    guideBox.setBackground(Color.BLACK)
    guideText.setPreferredSize(new Dimension(130, 40))
    guideText.setForeground(Color.RED)
    guideText.setText("X turn")
    guideBox.add(guideText)
    frame.add(guideBox)
    frame.setVisible(true)
  }
  def wtiteInGuide(turn: Int, flag: Boolean): Unit ={
    guideText.setText("")
    if(!flag){
      if(turn == 0){
        guideText.setText("X turn")
      }
      else{
        guideText.setText("O turn")
      }
    }
    else{
      if(turn == 0){
        guideText.setText("INVALID! X turn again")
      }
      else{
        guideText.setText("INVALID! O turn again")
      }
    }
  }

  def draw_X_O(turn: Int, i: Int, j: Int): Unit = {
    val label = new JLabel
    if (turn == 0) { //X turn
      label.setText("X")
      label.setFont(new Font("Comic Sans MS", Font.PLAIN, 100))
      label.setForeground(Color.green)
    }
    else { //O turn
      label.setText("O")
      label.setFont(new Font("Comic Sans MS", Font.PLAIN, 100))
      label.setForeground(Color.magenta)
    }
    panel(i)(j).setLayout(new GridBagLayout) //to put the text in the center

    panel(i)(j).add(label)
    frame.add(panel(i)(j))
    frame.setVisible(true)
  }

}