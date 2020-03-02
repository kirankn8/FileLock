/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Index;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressBar{
  public void pb(SmallBinaryFiles s) {
    JFrame parentFrame = new JFrame();
    parentFrame.setSize(500, 150);
    JLabel jl = new JLabel();
    jl.setText("Processing : 0");

    parentFrame.add(BorderLayout.CENTER, jl);
    parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    parentFrame.setVisible(true);

    final JDialog dlg = new JDialog(parentFrame, "Progress Dialog", true);
    JProgressBar dpb = new JProgressBar(0, 100);
    dlg.add(BorderLayout.CENTER, dpb);
    dlg.add(BorderLayout.NORTH, new JLabel("Progress..."));
    dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    dlg.setSize(300, 75);
    dlg.setLocationRelativeTo(parentFrame);

    Thread t = new Thread(new Runnable() {
      public void run() {
        dlg.setVisible(true);
      }
    });
    t.start();
    int i  = s.getbytepointer() ;
    while(i != 100 ) {
      jl.setText("Processing : " + i);
      dpb.setValue(i);
      i  = s.getbytepointer() ;
      if(dpb.getValue() == 100){
        dlg.setVisible(false);
        System.exit(0);
      }
      try {
        Thread.sleep(25);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    dlg.setVisible(true);
  }
}