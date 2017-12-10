package contactlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Per Sundberg
 *
 * Class for the in and output.
 */
class ContactList {
    private ContactManager contactManager;
    
    String txtLastName;
    String txtFirstName;
    String txtStreet;
    String txtZipCode;
    String txtCity;
    Scanner scanInput;
       
    /**
     * Constructor name same as class.
     * 
     */
    public ContactList()
    {
        initParameters();

        //Create instance of Contact manager
        contactManager = new ContactManager();
        
        //Create scanner for input
		scanInput = new Scanner(System.in);
        
        //Menu for in and output
        menu();
    }
    
    /**
     * Method to init the parameters
     * 
     */
    private void initParameters()
    {
        txtLastName = "";
        txtFirstName = "";
        txtStreet = "";
        txtZipCode = "";
        txtCity = "";
    }
        
    private void addContact()
    {	
    	System.out.println("First Name?");
    	txtFirstName = scanInput.nextLine();    	
    	
    	System.out.println("Last Name?");
    	txtLastName = scanInput.nextLine();    
    	
    	System.out.println("City?");
    	txtCity = scanInput.nextLine();  
    	
    	System.out.println("Street?");
    	txtStreet = scanInput.nextLine();      	
    	
    	System.out.println("Zipcode?");
    	txtZipCode = scanInput.nextLine();   
        	
    	if(readInput("Add",0))
    	{
    		System.out.println("Contact was successfully added");
    	}
    }
    
    private void displayContacts()
    {
        //Add all contact-info to list except for when null is found 
        for (int i = 0; i < contactManager.getCount(); i++)
        {
        	System.out.println(i+1 + ". " + contactManager.getContact(i).toString());
        }
    }
    
    private void changeContact()
    {
    	System.out.println("Number position for contact to be changed?");
    	String index = scanInput.nextLine(); 
    	int selectedIindex = Integer.parseInt(index);
    	
    	System.out.println(selectedIindex + ". " + contactManager.getContact(selectedIindex-1).toString());
    	
    	System.out.println("New First Name?");
    	txtFirstName = scanInput.nextLine();    	
    	
    	System.out.println("New Last Name?");
    	txtLastName = scanInput.nextLine();    
    	
    	System.out.println("New City?");
    	txtCity = scanInput.nextLine();  
    	
    	System.out.println("New Street?");
    	txtStreet = scanInput.nextLine();      	
    	
    	System.out.println("New Zipcode?");
    	txtZipCode = scanInput.nextLine();   
    	
    	if(readInput("Update",selectedIindex -1))
    	{
    		System.out.println("Contact was successfully Updated");
    	}
    }
    
    private void deleteContact()
    {
    	System.out.println("Number position for contact to be deleted?");
    	String index = scanInput.nextLine(); 
    	int selectedIindex = Integer.parseInt(index);	
    	
    	contactManager.DeleteContact(selectedIindex -1);
    }
    
    private void menu()
    {
    	boolean programEnded = false;
		String choice = "";
    	
    	System.out.println("Welcome to the contact list program");
    	System.out.println("1. Add a new contact");
    	System.out.println("2. Display contacts in list");    	
    	System.out.println("3. Change a contact");   	
    	System.out.println("4. Delete a contact");
    	System.out.println("5. Exit program");
    	
    	do {
           System.out.println("Make a selection?");
    	   choice = scanInput.nextLine();
    	   switch (choice)
    	   {
 	          case "1":
	    	      addContact();
	    	      break;
 	          case "2":
 	        	 displayContacts();
	    	      break;	   
 	          case "3":
 	        	 changeContact();
	    	      break;	
 	          case "4":
 	        	 deleteContact();
	    	      break;		    	      
    	      case "5":
    	    	  programEnded = true;
    	    	  break;
    	   }
    	} while (!programEnded);
    }
    
    /**
     * Method that reads the address.
     * 
     * @return address
     */
    private Address readAddress()
    {
        Address address = new Address();

        address.setStreet(txtStreet);
        address.setZipCode(txtZipCode);
        address.setCity(txtCity);

        return address;
    }
    
    /**
     * Method that adds the contact to lstResults.
     * 
     * @param contact
     */
    private void addContactToList(Contact contact)
    {
        contactManager.addContact(contact);
    }
    
    /**
     * Method that change contact in lstResults for an index.
     * 
     * @param contact
     */
    private void changeInContactList(Contact contact, int pos)
    {
        contactManager.changeContact(contact, pos);
    }    
    
    /**
     * Method that increase RegistredRecords.
     * 
     */
    private void updateRegistredRecords()
    {
        //lblRecords = contactManager.getCount();
    }    
    
    /**
     * Method that Reads the contact.
     * 
     * @param action
     * @return ok
     */
    private boolean readInput(String action, int pos)
    {

        //Create an object-instance of object.
        Contact contact = new Contact();

        //Add first and lastname to contact
        contact.setFirstName(txtFirstName);
        contact.setLastName(txtLastName);

        //Create instance of adress and get Address data for the contact.
        Address address = readAddress();

        //Connect address to contact
        contact.setAddressData(address);

        //Validate first-name, last-name and adress
        boolean ok = contact.Validate();

        if(ok)
        {
            if (action == "Add")
            {
                //Add Contact to contactlist.
                addContactToList(contact);
            }
            else
            {
                //Update Contactlist 
                changeInContactList(contact,pos);
            }
        }
        else
        {
           System.out.println("First name, last name and address must be correct.");
        }

        return ok;
    }    
                
}

/**
 * 
 * @author Per Sundberg
 *
 * Class where program starts.
 */
public class ContactListProgram {
    
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
       ContactList contacts = new ContactList();
	}

}
