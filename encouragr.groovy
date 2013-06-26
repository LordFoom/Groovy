import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import java.awt.Font
import javax.swing.JFrame

count = 0
font = new Font("SansSerif", Font.BOLD, 26)
myFrame = new SwingBuilder().edt {
  frame(title:'You rock!', size:[140,100], show: true, pack:true, locationRelativeTo: null, defaultCloseOperation:JFrame.EXIT_ON_CLOSE) {
    borderLayout()
    textlabel = label(text:" You are SO Cool! ", font: font, constraints: BL.CENTER)
    button(text:'Yes I AM!',
         actionPerformed: {myFrame.dispose()},
         constraints:BL.SOUTH)
  }
}
