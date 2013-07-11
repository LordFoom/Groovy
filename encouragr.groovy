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

myFrame = new SwingBuilder().edt {
  frame(title:'You rock!', size:[140,100], show: true, pack:true, locationByPlatform: true, defaultCloseOperation:JFrame.EXIT_ON_CLOSE) {
    borderLayout()
    textlabel = label(text:message, font: font, constraints: BL.CENTER)
    button(text:" It's True! ",
         actionPerformed: {myFrame.dispose()},
         constraints:BL.SOUTH)
  }
}

println "You're awesome!"
