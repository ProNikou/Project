import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;

public class Display extends JFrame{
	
	private ArrayList<Object> obj;
	private JList FriendsList; 
		private JList GroupList;
	public Display(ArrayList<Object> objects)
	{
	    obj=objects;
		JPanel contentPane = new JPanel();
		 FriendsList = new JList();
		 GroupList = new JList();
		contentPane.add(GroupList);
		contentPane.add(FriendsList);
		JScrollPane scroll = new JScrollPane(FriendsList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		DefaultListModel listModel = new DefaultListModel();
		
		for(Object OBJ: obj) {
			listModel.addElement( OBJ.getName());
		}		
		FriendsList.setModel(listModel);				
		contentPane.add(FriendsList, BorderLayout.WEST);
		
		DefaultListModel listModel2 = new DefaultListModel();
		
		for(Object OBJ2: obj) {
			listModel.addElement(OBJ2.getName());
		}		
		GroupList.setModel(listModel2);				
		contentPane.add(GroupList, BorderLayout.EAST);
		
		this.add(scroll);
		
		this.setContentPane(contentPane);
		
		this.setVisible(true);
		this.setSize(400, 200);
		this.setTitle("DisplayLists Frame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		}
		class Listener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			
			String selectedFriendName = (String) FriendsList.getSelectedValue();
			String selectedGroupName = (String) GroupList.getSelectedValue();
	
			Object selectedFriend = null;
			for(Object OBJ: obj) {
				if(OBJ.getName().equals(selectedFriendName))
					selectedFriend = OBJ;
			}
			
			Object selectedGroup= null;
			for(Object OBJ2: obj) {
				if(OBJ2.getName().equals(selectedGroupName))
					selectedGroup = OBJ2;
			}
			
			System.out.println("Friend name: " + selectedFriend.getName());
			System.out.println("Group name: " + selectedGroup.getName());
		}
		
	}
		
		
		
		
		
		
		pack();
		this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	
	

}
