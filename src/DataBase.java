import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//from this class we recover data from the save files
public class DataBase {
	// TODO double check users & groups about static
	//TODO failsafe saving of all new staff if someone is to close the program 
	

	private static ArrayList<User> users;
	private static ArrayList<Group> groups;

	
	public DataBase() {
		
		this.users = null;
		this.groups = null;
		
		
		
	}
	
	

	public static void CreateUser(String name, String mail, String password)
	{
		if(isUser(mail));
		User u = new User(name, mail, password);
	}
		
				

	
	
	public void deleteUser(User auser)
	{

		String input = JOptionPane.showInputDialog("Enter password to delete user");

		if(auser.isPasswordCorrect(input)) users.remove(auser);
		JOptionPane.showMessageDialog(null, auser.getName()+ "Deleted!!", "User Deleted!", JOptionPane.INFORMATION_MESSAGE);
	}
	

	public static void addGroup(Group agroup)
	{
		groups.add(agroup);
	}
	

	//TODO save --find better way
	public boolean save()
	{
		
		try {
			FileOutputStream fileOut = new FileOutputStream(".users.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
			JOptionPane.showMessageDialog(null, "Users could not be saved to file", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		finally {
			System.out.println("Users saved...");
		}
		try {
			FileOutputStream fileOut = new FileOutputStream(".groups.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(groups);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
			JOptionPane.showMessageDialog(null, "Groups could not be saved to file", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		finally {
			System.out.println("Groups saved...");
		}
		return true;
		
		
	}

	
	
	



	
	
	public boolean retrieveAll()
	{
		this.retrievalOfObject(users);
		this.retrievalOfObject(groups);

		
		return true;

	}


	public ArrayList<Group> getgroups() {
		// TODO Retrieve groups from savefiles
		return groups;

	}

	public boolean retrievalOfObject(Object ObjectType)
	{
		String name = ObjectType.getClass().getName();
		try {
			FileInputStream fileIn = new FileInputStream("."+ name + ".txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			ArrayList<Object> users = (ArrayList<Object>) in.readObject();//TODO check


			in.close();
			fileIn.close();	
			
		}
		catch(IOException i) {
			i.printStackTrace();
			JOptionPane.showMessageDialog(null, "Could not be retrieved from file", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
			return false;
		}
		finally {
			System.out.println("Loaded");
			
		}
		return true;
	}
	
//TODO complete getUserInstance
	public User getUserInstance(String username)
	{
		for(User u : users)
		{
			if(u.getName().equals(username))
			{
				return u;
			}
		}
		JOptionPane.showMessageDialog(null,"User not found!","Message",JOptionPane.WARNING_MESSAGE);
		return null;
	}

	public Group getGroupInstance(String groupname)
	{
		for(Group g : groups)
		{
			if(g.getName().equals(groupname))
			{
				return g;
			}
		}
		JOptionPane.showMessageDialog(null,"Group not found!","Message",JOptionPane.WARNING_MESSAGE);

		return null;
	}
	
	//TODO check checkUser ** static?

	public static boolean checkUser(String name)

	{
		for(User u : users)
		{
			if(u.getName().equals(name))
			{
				while(true)
				{
				String input = JOptionPane.showInputDialog("Enter Input:");
				if(u.isPasswordCorrect(input)) return true;
				}
			}
		}
		
		
		JOptionPane.showMessageDialog(null,"User not found!","Message",JOptionPane.PLAIN_MESSAGE);
		return false;
	}

	public static boolean isUser(String mail)
	{
		for(User u : users)
		{
			if(u.getMail().equals(mail))

			{
				return true;
			}			
		}
		JOptionPane.showMessageDialog(null,"User not found!","Message",JOptionPane.PLAIN_MESSAGE);
		return false;
	}
	
	
	

	public static boolean isgroup(String g)
	{
		for(Group gr : groups)
		{
			if(gr.getName().equals(g))
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	
	

}
