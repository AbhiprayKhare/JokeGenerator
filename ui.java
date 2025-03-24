import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ui extends Joker {
    public static void main(String[] args) {
        
    	getjoke();

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Ajeeb jokes");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(120, 60, 120, 20)); 
        
        
        JLabel setupLabel = new JLabel("<html><b>" + setup + "</b></html>", SwingConstants.CENTER);
        JLabel deliveryLabel = new JLabel("<html><i> " + delivery + "</i></html>", SwingConstants.CENTER);
        setupLabel.setFont(new Font("Arial", Font.BOLD, 22));
        deliveryLabel.setFont(new Font("Arial", Font.ITALIC, 19));
        
        JButton jbutt=new JButton("One more Joke");
        jbutt.setFont(new Font("Arial",Font.PLAIN,15));
        jbutt.setBackground(Color.blue);
        jbutt.setForeground(Color.cyan);
        jbutt.setFocusPainted(false);
        jbutt.setPreferredSize(new Dimension(200,50));
        jbutt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getjoke();
				
				while(setup==null)
				{
					getjoke();
					if(setup!=null)
					{
						break;
					}
				}
				setupLabel.setText(setup);
				deliveryLabel.setText(delivery);
			}
		});

        panel.setBackground(Color.BLACK);
        panel.add(setupLabel,BorderLayout.NORTH);
        panel.add(deliveryLabel,BorderLayout.CENTER);
        panel.add(jbutt,BorderLayout.SOUTH);
        
        
        setupLabel.setForeground(Color.ORANGE);
        deliveryLabel.setForeground(Color.green);

        window.add(panel);
        
        window.pack();
        window.setSize(800, 550);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
