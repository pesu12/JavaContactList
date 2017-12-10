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
        	
    	if(readInput("Add"))
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
    private void changeInContactList(Contact contact)
    {
        //contactManager.ChangeContact(contact, lstResultsChangeIndex);
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
    private boolean readInput(String action)
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
                changeInContactList(contact);
            }
        }
        else
        {
           System.out.println("First name, last name and address must be correct.");
        }

        return ok;
    }    
    
    
    
    /**
     * Method that gives error if change or cancel buttons are clicked on.
     * 
     * @return result
     */
    private boolean listIsEmpty()
    {
        if (contactManager.getCount() == 0)
        {
            //MessageBox.Show("Action can not be performed. List is empty.");
            return true;
        }
        return false;
    }
    
    /**
     * Method that executes when button Change is clicked on.
     * 
     */
    private void btnChange_Click()
    {
        if(!listIsEmpty())
        {
            boolean ok = readInput("Change");
            if (ok)
            {
            }
        }
    }
    
    /**
     * Method that executes when button Cancel is clicked on.
     * 
     */
    private void btnCancel_Click()
    {
        if (!listIsEmpty())
        {

            //if (lstResults.SelectedIndex != -1)
            //{
            //    contactManager.DeleteContact(lstResults.SelectedIndex);
            //}
            //Rebuild the Contactlist.
            //updateGUI();
        }
    }
    
    /**
     * Method to get contact from list and add it to contact inputs.
     * 
     */
    private void getContactFromList()
    {
        Contact contact = new Contact();

        //contact = contactManager.getContact(lstResultsChangeIndex);
        txtFirstName = contact.getFirstName();
        txtLastName = contact.getLastName();
        txtStreet = contact.getAddressData().getStreet();
        txtZipCode = contact.getAddressData().getZipCode();
        txtCity = contact.getAddressData().getCity();
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
