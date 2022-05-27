import java.awt.Color
import java.awt.Graphics
import java.awt.event.{ActionEvent, ActionListener, MouseListener}
import java.util
import javax.swing.{Action, JButton, JFrame, JLabel, JPanel, JTextField}


class CheckersBoard extends JPanel  {
  var A=Array(8,7,6,5,4,3,2,1)
  var C=Array("A","B","C","D","E","F","G","H")
  var XLABEL:String =null
  var YLABEL:Int=0
  var properties1=new util.ArrayList[Piece]()
  //var properties2=new util.ArrayList[util.ArrayList[Int]]()

  var counter=0
  def update(g:Graphics ,h:String):Unit={
    var t1=new JTextField();;
    var t2=new JTextField();;
    class CustomActionListener extends ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var FROM = t1.getText
        var TO = t2.getText
        var instance = new Checkers_Controller
        instance.UpdateMove(g,FROM,TO)
      }
    }
    var f= new JFrame("Determine the move");
    var title=new JButton("Enter")
    title.addActionListener(new CustomActionListener())
    title.setBounds(270,100,100,50)
    var l=new JLabel(h)
    l.setBounds(29,0,100,40)
    l.setVisible(true)
    var lt1=new JLabel("From :")
    lt1.setBounds(10,30,50,30)


    t1.setBounds(60,30,200,30)
    var lt2=new JLabel("TO :")
    lt2.setBounds(10,80,50,30)

    t2.setBounds(60,90, 200,30);

    f.add(t1); f.add(t2); f.add(l);
    f.add(title); f.add(lt1); f.add(lt2);
    f.setSize(400,200);
    f.setLayout(null);

    f.setVisible(true);

  }
  override def paint(g: Graphics): Unit = {
  update(g,"Player1")
    g.setColor(Color.BLACK)
    var k=0
    var m=120
    g.fillRect(100, 100, 400, 400)
    var i = 100



    while ( {i <= 400}) {
      var j = 100
      while ( {j <= 400}) {
        g.setColor(Color.red)
        g.fillRect(i, j, 50, 50)
        if(j<250)
        { g.setColor(Color.LIGHT_GRAY)
          var instanP=new Piece()
          instanP.setisWhite(true) //its colour is white
          instanP.setX(i+50+5)  //setx position
          instanP.setY(j+5)  //sety position
          System.out.print("llllllllllllll"+A(k) +C(k))
          instanP.setchar(C(k)); instanP.setInt(A(k))
          properties1.add(counter,instanP)
          counter+=1
          g.fillOval(i+50+5,j+5,30,30)}
        else if(j>350 ){
          g.setColor(Color.DARK_GRAY)
          var instanP=new Piece()
          instanP.setisWhite(false) //its colour is white
          instanP.setX(i+50+5)  //setx position
          instanP.setY(j+5)  //sety position
          instanP.setchar(C(k)); instanP.setInt(A(k))
          properties1.add(counter,instanP)
          counter+=1
          g.fillOval(i+5+50,j+5,30,30)
        }
        j += 100

      }

      i+= 100
      g.setColor(Color.BLACK)

      g.drawString(A(k)+"",510,m+5)
      g.drawString(A(k)+"",90,m+5)
      g.drawString(C(k),m,95)
      g.drawString(C(k),m,520)
      k+=1
      m+=50
    }
    i = 150

    while ( {i <= 450}) {
      var j = 150

      while ( {j <= 450}) {
        g.setColor(Color.red)
        g.fillRect(i, j, 50, 50)

        if(j<250)
        { g.setColor(Color.LIGHT_GRAY)
          var instanP=new Piece()
          instanP.setisWhite(true) //its colour is white
          instanP.setX(i-50+5)  //setx position
          instanP.setY(j+5)  //sety position
          instanP.setchar(C(k)); instanP.setInt(A(k))
          properties1.add(counter,instanP)
          counter+=1
          g.fillOval(i+5-50,j+5,30,30)}
        else if(j>250){
          g.setColor(Color.DARK_GRAY)
          var instanP=new Piece()
          instanP.setisWhite(false) //its colour is black
          instanP.setX(i-50+5)  //setx position
          instanP.setY(j+5)  //sety position
          instanP.setchar(C(k)); instanP.setInt(A(k))
          properties1.add(counter,instanP)
          counter+=1
          g.fillOval(i+5-50,j+5,30,30)
        }

        j += 100
      }

      i += 100

      g.setColor(Color.BLACK)
      g.drawString(A(k)+"",510,m+5)
      g.drawString(A(k)+"",90,m+5)
      g.drawString(C(k),m,95)
      g.drawString(C(k),m,520)
      k+=1
      m+=50

    }
  }
}
