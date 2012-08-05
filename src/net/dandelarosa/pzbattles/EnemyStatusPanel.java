package net.dandelarosa.pzbattles;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EnemyStatusPanel extends JPanel {
  /**
   * 
   */
  private static final long serialVersionUID = 607087611776688826L;
  
  private JLabel hpTitle = new JLabel("Enemy HP:");
  private JLabel hpValue = new JLabel();
  
  public EnemyStatusPanel() {
    this.add(hpTitle);
    this.add(hpValue);
    hpValue.setText(Integer.toString(100));
  }
  
  public void updateHP(int hp) {
    hpValue.setText(Integer.toString(hp));
  }
}
