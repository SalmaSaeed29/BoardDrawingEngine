import java.awt.Graphics
import scala.Byte.MaxValue

class Checkers_Controller {
   def controller(g:Graphics, from: String, To: String): Unit = {

     if (from.startsWith("A") ) {
       System.out.print("from: "+from)
     }
   }
   def UpdateMove(g:Graphics,from: String, To: String):Unit={
     var instanceG=new CheckersBoard
     var j =0
     var i=0
     System.out.println("out"+ from +To)
     instanceG.paint(g)
     System.out.println(instanceG.properties1.isEmpty)
     if(!instanceG.properties1.isEmpty)
     {  var in=instanceG.properties1.size()
       do{
         System.out.print("INTTT " + instanceG.properties1.get(i).getInt())
         System.out.print("ChAR " + instanceG.properties1.get(i).getchar())
         System.out.println("index" + instanceG.properties1.get(i).getX())
         System.out.print("colourrr" +instanceG.properties1.get(i).getisWhite)

         i+=1
       }while(i<in)

     }
   }
}
