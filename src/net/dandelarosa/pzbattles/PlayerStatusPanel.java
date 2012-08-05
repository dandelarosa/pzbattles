package net.dandelarosa.pzbattles;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerStatusPanel extends JPanel {
  /**
   * 
   */
  private static final long serialVersionUID = 148317686358424207L;
  
  private JLabel hpTitle = new JLabel("Player HP:");
  private JLabel hpValue = new JLabel();
  
  public PlayerStatusPanel() {
    this.add(hpTitle);
    this.add(hpValue);
    hpValue.setText(Integer.toString(100));
  }
  
  public void updateHP(int hp) {
    hpValue.setText(Integer.toString(hp));
  }
}
