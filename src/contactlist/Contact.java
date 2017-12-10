package contactlist;

/**
 * 
 * @author Per Sundberg
 *
 * This class handles the Contacts for the contact registry
 *
 */
public class Contact {
	
    private Address address;
    private String firstName;
    private String lastName;

    /**
     * Constructor with name same as class, no input parameters.
     * 
     */
    public Contact()
    {
    	this("", "", new Address());
    }
    
    /**
     * Constructor with name same as class, copy-constructor.
     * 
     * @param theOther
     */
    public Contact(Contact theOther)
    {
        this.firstName = theOther.firstName;
        this.lastName = theOther.lastName;
        this.address = theOther.address;
    }    
    
    /**
     * Constructor with name same as class, overloaded.
     * 
     * @param firstName
     * @param lastName
     * @param addr
     */
    public Contact(String firstName, String lastName, Address addr)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = addr;
    }    
    
    /**
     * Method that sets the address.
     * 
     * @param value
     */
    public void setAddressData(Address value)
    {
        if (value != null)
        {
        	address = value;
        }
    }
    
    /**
     * Method that gets the address.
     * 
     * @return address
     */
    public Address getAddressData()
    {
    	return address;
    } 
    
    
    /**
     * Method that sets the first-name.
     * 
     * @param value
     */
    public void setFirstName(String value)
    {
        if (value != null)
        {
        	 firstName = value;
        }
    }
    
    /**
     * Method that gets the first-name.
     * 
     * @return
     */
    public String getFirstName()
    {
    	return firstName;
    }     
    
    /**
     * Method that sets the last-name.
     * 
     * @param value
     */    
    public void setLastName(String value)
    {
        if (value != null)
        {
        	 lastName = value;
        }
    }
    
    /**
     * Method that gets the last-name.
     * 
     * @return lastName
     */
    public String getLastName()
    {
    	return lastName;
    }         
    
    /**
     * Method that gets the full-name.
     * 
     * @return fullName
     */
    public String getFullName()
    {
    	return firstName + " " + lastName;
    }
    
    /**
     * Method that gets the Contact as a string.
     * 
     * @return str
     */
    public String toString()
    {
        String str = "Name: " + getFullName() + "," + address.toString();
        return str;
    }  
    
    /**
     * Method to validate Contact.
     * 
     * @return ok
     */
    public boolean Validate()
    {
        boolean ok = true;

        if (firstName == "")
        {
            ok = false;
        }

        if (lastName == "")
        {
            ok = false;
        }

        //Validate the adress
        ok = address.Validate();

        return ok;
    }    
}
