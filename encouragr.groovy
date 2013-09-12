#!/usr/bin/env groovy
import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import java.awt.Font
import javax.swing.JFrame
import java.util.Random

println "Who's awesome?"

font = new Font("SansSerif", Font.BOLD, 46)

scriptDir = new File(getClass().protectionDomain.codeSource.location.path).parent
happy_thoughts = new File(scriptDir+"/happy_thoughts.groovy").readLines()
rand = new Random()
message = happy_thoughts[rand.nextInt(happy_thoughts.size)]
button_text = "It's true!"
//do we have button text, ie text that comes after a ':'?
message_parts = message.split(":")
if(message_parts.size() == 2)
{
    message = message_parts[0]
    button_text = message_parts[1]
}

myFrame = new SwingBuilder().edt {
  frame(title:'You rock!', size:[140,100], show: true, pack:true, locationByPlatform: true, defaultCloseOperation:JFrame.EXIT_ON_CLOSE) {
    borderLayout()
    textlabel = label(text:" "+message+" ", font: font, constraints: BL.CENTER)
    button(text:button_text,
         actionPerformed: {myFrame.dispose()},
         constraints:BL.SOUTH)
  }
}

println "You're awesome!"
