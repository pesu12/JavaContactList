package contactlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Per Sundberg
 *
 * This class that is responsible for adding, deleting, changing and all other
 * operation on the contact list.
 */
public class ContactManager {

	private List<Contact> contactRegistr�;
	
	/**
	 * Constructor with name same as class.
	 * 
	 */
    public ContactManager()
    {
        contactRegistr� = new ArrayList<Contact>();
    }
    
    /**
     * Method that gets the numbers of contacts in contact-list
     * 
     * @return size of contact-list
     */
    public int getCount()
    {
        return contactRegistr�.size();
    }
    
    /**
     * Method that Add Contact.
     * 
     * @param contactIn
     * @return true
     */
    public boolean addContact(Contact contactIn)
    {
        contactRegistr�.add(contactIn);
        return true;
    }
    
    /**
     * Method that change Contact
     * 
     * @param contactIn
     * @param index
     * @return true
     */
    public boolean changeContact(Contact contactIn, int index)
    {
        contactRegistr�.set(index,contactIn);
        return true; 
    }
    
    /**
     * Method that deletes a contact.
     * 
     * @param index
     * @return true
     */
    public boolean DeleteContact(int index)
    {
        contactRegistr�.remove(index);
        return true; 
    }    
    
    /**
     * /Method to verify if the position in contact list is empty.
     * 
     * @param index
     * @return result
     */
    public boolean isPositionInListEmpty(int index)
    {
        boolean result = false;
        if (contactRegistr�.get(index) == null)
        {
            result = true;
        }
        return result;
    }
    
    /**
     * Method that gets a Contact.
     * 
     * @param index
     * @return copy of the contact object.
     */
    public Contact getContact(int index)
    {
        //Copying is done so that it will not affect the contactRegistr� directly.
        Contact copyObj = new Contact(contactRegistr�.get(index));  
        return copyObj;
    }
    
    /**
     * Method that get all ContactsInfo as a string.
     * 
     * @return str
     */
    public String[] getContactsInfo()
    {
        String[] str = new String[getCount()];
        for (int i = 0; i < getCount(); i++)
        {
            Contact contactCopy = getContact(i);
            str[i] = contactCopy.toString(); 
        }
        return str; 
    }
}
