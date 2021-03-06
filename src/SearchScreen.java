import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchScreen extends JFrame{
	
	private JTextField username;
	private JButton Search;
	
	
	public SearchScreen()
	{
		super("Search Screen");
		JPanel contentPane = new JPanel();
		
		JRadioButton usersearch = new JRadioButton("Users Search", true);
        JRadioButton groupsearch = new JRadioButton("Group Search", false);
 
        ButtonGroup group = new ButtonGroup();
        group.add(usersearch);
        group.add(groupsearch);
 
        setLayout(new FlowLayout());
        
        Search = new JButton("Sign_up in");
		contentPane.add(Search);
		Search.addActionListener(new SearchActionListener());
 
        contentPane.add(usersearch);
        contentPane.add(groupsearch);
       
        contentPane.add(username);
        
 
        pack();
        this.setVisible(true);
	
	}
	class SearchActionListener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO 			 	
			}
	 }

}
