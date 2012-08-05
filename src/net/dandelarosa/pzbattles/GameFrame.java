package net.dandelarosa.pzbattles;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameFrame extends JFrame implements ActionListener {
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
    
    JPanel panel = new JPanel(new GridBagLayout());
    this.add(panel);
    
    //Add Components to this panel.
    GridBagConstraints c = new GridBagConstraints();
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 0.5;
    panel.add(playerStatusPanel, c);
    
    c.gridx = 1;
    c.gridy = 0;
    c.weightx = 0.5;
    panel.add(enemyStatusPanel, c);
    
    c.gridx = 0;
    c.gridy = 1;
    c.weightx = 0.5;
    panel.add(attackButton, c);
    attackButton.addActionListener(this);
    
    c.gridx = 1;
    c.gridy = 1;
    c.weightx = 0.5;
    panel.add(defendButton, c);
    defendButton.addActionListener(this);
    
    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 2;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.gridwidth = 2;
    console.setEditable(false);
    console.setLineWrap(true);
    console.setWrapStyleWord(true);
    JScrollPane consoleScroll = new JScrollPane(console);
    panel.add(consoleScroll, c);
    
    pack();
    setVisible(true);
  }
  
  JTextArea console = new JTextArea(10, 30);
  PlayerStatusPanel playerStatusPanel = new PlayerStatusPanel();
  EnemyStatusPanel enemyStatusPanel = new EnemyStatusPanel();
  private JButton attackButton = new JButton("Attack");
  private JButton defendButton = new JButton("Defend");
  private int playerHP = 100;
  private int enemyHP = 100;

  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    
    if (source == attackButton) {
      // Attack - do normal damage, take normal damage
      enemyHP -= 20;
      enemyStatusPanel.updateHP(enemyHP);
      playerHP -= 10;
      playerStatusPanel.updateHP(playerHP);
      console.append("Attack\n");
    }
    else if (source == defendButton) {
      // Defend - do no damage, take half damage
      playerHP -= 5;
      playerStatusPanel.updateHP(playerHP);
      console.append("Defend\n");
    }
    
    if (playerHP <= 0 || enemyHP <= 0) {
      if (playerHP <= 0) {
        console.append("You lose!\n");     
      } else if (enemyHP <= 0) {
        console.append("You win!\n");
      }
      attackButton.setEnabled(false);
      defendButton.setEnabled(false);
    }
  }
}
