/**
 * 
 */
package model.model;

/**
 * @author ok
 *
 */
public class Supplier {
	
	private String Name;
	private String number;
	private String number1;
	private int supId;
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the number1
	 */
	public String getNumber1() {
		return number1;
	}

	/**
	 * @param number1 the number1 to set
	 */
	public void setNumber1(String number1) {
		this.number1 = number1;
	}

	/**
	 * @return the supId
	 */
	public int getSupId() {
		return supId;
	}

	/**
	 * @param supId the supId to set
	 */
	public void setSupId(int supId) {
		this.supId = supId;
	}

	public Supplier(String Name, String number, String num, int id)
	{
		this.Name = Name;
		this.number = number;
		this.supId = id;
		this.number1 = num;
		
	}
}
