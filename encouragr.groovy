import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import java.awt.Font
import javax.swing.JFrame
import java.util.Random

font = new Font("SansSerif", Font.BOLD, 46)

def happy_thoughts = new File("happy_thoughts.groovy").readLines()
Random rand = new Random()
def message = happy_thoughts[rand.nextInt(happy_thoughts.size)]

myFrame = new SwingBuilder().edt {
  frame(title:'You rock!', size:[140,100], show: true, pack:true, locationRelativeTo: null, defaultCloseOperation:JFrame.EXIT_ON_CLOSE) {
    borderLayout()
    textlabel = label(text:message, font: font, constraints: BL.CENTER)
    button(text:' Yes! ',
         actionPerformed: {myFrame.dispose()},
         constraints:BL.SOUTH)
  }
}



