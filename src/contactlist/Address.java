package contactlist;

/**
 * 
 * @author Per Sundberg
 *
 * This class handles the address for the contact registry
 * 
 */
public class Address {
	
    private String city;
    private String street;
    private String zipCode;
    
    /**
     * Constructor with name same as class, no input parameters.
     */
    public Address() 
    { 
    	 this("", "", "Stockholm");
    }    
    
    /**
     * Constructor with name same as class, copy-constructor.
     * 
     * @param theOther
     */
    public Address(Address theOther)
    {
        this.street = theOther.street;
        this.zipCode = theOther.zipCode;
        this.city = theOther.city;
    }   
    
    /**
     * Constructor with name same as class, overloaded.
     * 
     * @param street
     * @param zip
     * @param city
     */
    public Address(String street, String zip, String city)
    {
        this.street = street;
        this.zipCode = zip;
        this.city = city;
    }    
    
    
    /**
     * Method that sets the city.
     * 
     * @param value
     */
    public void setCity(String value)
    {
        if (value != null)
        {
            city = value;
        }
    }
    
    /**
     * Method that gets the city.
     * 
     * @return city
     */
    public String getCity()
    {
    	return city;
    }    


    /**
     * Method that sets the street.
     * 
     * @param value
     */    
    public void setStreet(String value)
    {
        if (value != null)
        {
            street = value;
        }
    }
    
    /**
     * Method that gets the street.
     *    
     * @return street
     */
    public String getStreet()
    {
    	return street;
    }      
    
    /**
     * Method that sets the zipcode.
     * 
     * @param value
     */      
    public void setZipCode(String value)
    {
        if (value != null)
        {
        	zipCode = value;
        }
    }
    
    /**
     * Method that gets the zipcode.
     * 
     * @return
     */
    public String getZipCode()
    {
    	return zipCode;
    }        
    
    
    /**
     * Method to get the whole as a single string.
     * 
     * @return str
     */
    public String toString()
    {
        String str = " Street: " + street + ", ZipCode: " + zipCode + ", City: " + city; 
        		//getCountryString());
        return str;
    }   
    
    /**
     * Method to validate Address.
     * 
     * @return ok
     */
    public boolean Validate()
    {
        boolean ok = true;

        if (street =="")
        {
            ok = false;
        }

        if (city == "")
        {
            ok = false;
        }

        if (zipCode == "")
        {
            ok = false;
        }
        return ok;
    }    
}
