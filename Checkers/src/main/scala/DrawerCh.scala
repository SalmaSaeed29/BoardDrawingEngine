import javax.swing._
import java.awt._

class DrawerCh extends JFrame {

  var frame = new JFrame //create a frame
  var panel = Array.ofDim[JPanel](8, 8) //cells
  var cell = Array.ofDim[Char](8, 8) //array of the board
  var label = Array.ofDim[JLabel](8, 8) //circles
  var jump = false

  //initialize the cell array
  def initCell() {
    for (i <- 0 until 8) {
      for (j <- 0 until 8) {
        cell(i)(j) = ' '
      }
    }
  }

  var nonoPanels = new Array[JPanel](32) //to put numbers and letters
  var nonoLabels = new Array[JLabel](32) //numbers and letters
  var boxContainer = new JPanel //input
  var box = new JTextField
  var guideBox = new JPanel //guide box
  var guideText = new JTextField

  def drawFrame(): Unit = {
    frame.setTitle("Checkers!")
    frame.setSize(480 + 15, 480 + 39 + 80) //frame size

    //frame.setResizable(false);
    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE)
    frame.getContentPane.setBackground(Color.black)
    frame.setLayout(null)
    frame.setVisible(true) //make frame visible

    //create the cells
    var x = 15
    var y = 15
    for (i <- 0 until 8) {
      for (j <- 0 until 8) {
        panel(i)(j) = new JPanel
        if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
          panel(i)(j).setBackground(Color.RED)
        }
        else {
          panel(i)(j).setBackground(Color.BLACK)
        }
        panel(i)(j).setBounds(x, y, 50, 50)
        frame.add(panel(i)(j))
        x += 50
      }
      x = 15
      y += 50
    }
    /*create numbers of cells inside
    * display numbers from 8 to 1 in right and left
    */
    var xnono = 0
    var ynono = 15
    var num = 0
    var cellNum = 8
    for (i <- 0 until 16) {
      nonoPanels(i) = new JPanel
      nonoLabels(i) = new JLabel
      nonoPanels(i).setBackground(Color.WHITE)
      nonoPanels(i).setBounds(xnono, ynono, 15, 50)
      nonoLabels(i).setText(String.valueOf({
        cellNum -= 1;
        cellNum + 1
      }))
      nonoPanels(i).setLayout(new GridBagLayout)
      nonoPanels(i).add(nonoLabels(i))
      frame.add(nonoPanels(i))
      ynono += 50
      num += 1
      if (num == 8) {
        xnono = 415
        ynono = 15
        cellNum = 8
      }
    }
    /*
     * display letters from a to c up and down
     */
    xnono = 15
    ynono = 0
    var cellLet = 'a'
    for (i <- 16 until 32) {
      nonoPanels(i) = new JPanel
      nonoLabels(i) = new JLabel
      nonoPanels(i).setBackground(Color.WHITE)
      nonoPanels(i).setBounds(xnono, ynono, 50, 15)
      nonoLabels(i).setText(String.valueOf({
        cellLet
      }))
      cellLet = ((cellLet + 1).toInt).toChar
      nonoPanels(i).setLayout(new GridBagLayout)
      nonoPanels(i).add(nonoLabels(i))
      frame.add(nonoPanels(i))
      xnono += 50
      num += 1
      if (num == 24) {
        ynono = 415
        xnono = 15
        cellLet = 'a'
      }
    }
    frame.setVisible(true)
  }

  //draw the box of text field
  def drawBox(): Unit = {
    boxContainer.setBounds(0, 420 + 20 + 30, 200, 50)
    boxContainer.setBackground(Color.BLACK)
    box.setPreferredSize(new Dimension(190, 40))
    boxContainer.add(box)
    frame.add(boxContainer)
    frame.setVisible(true)
  } //end of function

  //draw a box to display the turn
  def guide(): Unit = {
    guideBox.setBounds(220, 420 + 20 + 30, 200, 50)
    guideBox.setBackground(Color.BLACK)
    guideText.setPreferredSize(new Dimension(190, 40))
    guideText.setForeground(Color.RED)
    guideText.setText("Dark Grey turn")
    guideBox.add(guideText)
    frame.add(guideBox)
    frame.setVisible(true)
  }

  def wtiteInGuide(turn: Int, flag: Boolean): Unit = {
    guideText.setText("")
    if (!flag) {
      if (turn == 0) {
        guideText.setText("Dark Grey turn")
      }
      else {
        guideText.setText("Light Grey turn")
      }
    }
    else {
      if (turn == 0) {
        guideText.setText("INVALID! Dark Grey turn again")
      }
      else {
        guideText.setText("INVALID! Light Grey turn again")
      }
    }
  }

  def draw_circle(turn: Int, i: Int, j: Int): Unit = {
    label(i)(j) = new JLabel
    label(i)(j).setText("●")
    if (turn == 0) { //dark grey turn
      cell(i)(j) = '.' //fill the array"DARK"
      label(i)(j).setForeground(Color.darkGray)
    }
    else { //light grey turn
      cell(i)(j) = '-' //fill the array"LIGHT"
      label(i)(j).setForeground(Color.lightGray)
    }
    label(i)(j).setFont(new Font("Calibri", Font.BOLD, 70))
    label(i)(j).setSize(60, 60)
    panel(i)(j).setLayout(new GridBagLayout) //to put the text in the center

    panel(i)(j).add(label(i)(j))
    frame.add(panel(i)(j))
    frame.setVisible(true)
  }

  def delete_circle(i: Int, j: Int): Unit = {
    cell(i)(j) = ' ' //delete from the array

    panel(i)(j).remove(label(i)(j))
    panel(i)(j).revalidate()
    panel(i)(j).repaint()
  }

  def printDcell(): Unit = {
    println("elements in cell")
    for (i <- 0 until 8) {
      for (j <- 0 until 8) {
        System.out.print(cell(i)(j))
      }
      println()
    }
  }

  //function to check if the cell is empty
  def valid_cell(turn: Int, index: Array[Int]): Boolean = {
    jump = false

    val i = index(0)
    val j = index(1)
    val I = index(2)
    val J = index(3)

    if ((cell(i)(j) == '.' || cell(i)(j) == '-') && cell(I)(J) == ' ') {
      if (turn == 0) { //DARK grey turn
        if (cell(i)(j) == '.' && i - I == 1 && (j - J).abs == 1) {
          jump = false
          return true
        }
        else if (cell(i)(j) == '.' && i - I == 2 && j - J == 2 && cell(i - 1)(j - 1) == '-') { //jump left
          jump = true
          return true
        }
        else if (cell(i)(j) == '.' && i - I == 2 && J - j == 2 && cell(i - 1)(j + 1) == '-') { //jump right
          jump = true
          return true
        }
        else{
          return false
        }
      }
      else { //LIGHT grey turn
        if (cell(i)(j) == '-' && I - i == 1 && (j - J).abs == 1) {
          jump = false
          return true
        }
        else if (cell(i)(j) == '-' && I - i == 2 && j - J == 2 && cell(i + 1)(j - 1) == '.') { //jump left
          jump = true
          return true
        }
        else if (cell(i)(j) == '-' && I - i == 2 && J - j == 2 && cell(i + 1)(j + 1) == '.') { //jump right
          jump = true
          return true
        }
        else{
          return false
        }
      }
    }
    false
  }

  /*def jump(turn: Int, index: Array[Int]): Boolean = {
    val i = index(0)
    val j = index(1)
    val I = index(2)
    val J = index(3)

      if (turn == 0) { //DARK grey turn
        if (cell(i)(j) == '.' && i - I == 2 && j - J == 2 && cell(i - 1)(j - 1) == '-') { //jump left
           true
        }
        else if (cell(i)(j) == '.' && i - I == 2 && J - j == 2 && cell(i - 1)(j + 1) == '-') { //jump right
           true
        }
      }
      else { //LIGHT grey turn
        if (cell(i)(j) == '-' && I - i == 2 && j - J == 2 && cell(i + 1)(j - 1) == '.') { //jump left
           true
        }
        else if (cell(i)(j) == '-' && I - i == 2 && J - j == 2 && cell(i + 1)(j + 1) == '.') { //jump right
          return true
        }
      }
    false
  }*/

  def initialize(): Unit ={
    initCell()
    drawFrame()
    for(i <- 0 until 3){
      for(j <- 0 until  8){
        if((i%2==0 && j%2==1) || (i%2==1 && j%2==0)) {
          draw_circle(1, i, j)
        }
      }
    }//end of initial light grey
    for(i <- 5 until 8){
      for(j <- 0 until  8){
        if((i%2==0 && j%2==1) || (i%2==1 && j%2==0)) {
          draw_circle(0, i, j)
        }
      }
    }//end of initial dark grey
    drawBox()
    guide()
  }

}