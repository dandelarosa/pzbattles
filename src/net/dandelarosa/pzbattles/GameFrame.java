package net.dandelarosa.pzbattles;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = 5137530670379837351L;

  public GameFrame() {
    setTitle("Project Zero Arena");
    setSize(550, 400);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Center the window
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenDimensions = tk.getScreenSize();
    setLocation((screenDimensions.width - this.getWidth()) / 2,
        (screenDimensions.height - this.getHeight()) / 2);
    
    setVisible(true);
  }
}
