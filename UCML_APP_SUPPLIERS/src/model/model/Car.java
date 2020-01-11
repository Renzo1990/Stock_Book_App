/**
 * 
 */
package model.model;



/**
 * @author ok
 *
 */
public class Car {
	
	private int id;
	private String make;
	private String model;
	private String transmission;
	private String EngineSize;
	private String Colour;
	private String desc;
	private boolean status;
	private int yearModel;
	private String bodyType;
	private Supplier Owner;
	private int mileage;
	private String supplierDetails;
	private int carPrice;
	private String carDetails;
	private String variants;
	/**
	 * @return the variants
	 */
	public String getVariants() {
		return variants;
	}

	/**
	 * @param variants the variants to set
	 */
	public void setVariants(String variants) {
		this.variants = variants;
	}

	/**
	 * @return the carDetails
	 */
	public String getCarDetails() {
		return carDetails;
	}

	/**
	 * @param carDetails the carDetails to set
	 */
	public void setCarDetails(String carDetails) {
		this.carDetails = carDetails;
	}

	/**
	 * @return the carPrice
	 */
	public int getCarPrice() {
		return carPrice;
	}

	/**
	 * @param carPrice the carPrice to set
	 */
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	/**
	 * @return the supplierDetails
	 */
	public String getSupplierDetails() {
		return supplierDetails;
	}

	/**
	 * @param supplierDetails the supplierDetails to set
	 */
	public void setSupplierDetails(String supplierDetails) {
		this.supplierDetails = supplierDetails;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the transmission
	 */
	public String getTransmission() {
		return transmission;
	}

	/**
	 * @param transmission the transmission to set
	 */
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	/**
	 * @return the engineSize
	 */
	public String getEngineSize() {
		return EngineSize;
	}

	/**
	 * @param engineSize the engineSize to set
	 */
	public void setEngineSize(String engineSize) {
		EngineSize = engineSize;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return Colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		Colour = colour;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the yearModel
	 */
	public int getYearModel() {
		return yearModel;
	}

	/**
	 * @param yearModel the yearModel to set
	 */
	public void setYearModel(int yearModel) {
		this.yearModel = yearModel;
	}

	/**
	 * @return the bodyType
	 */
	public String getBodyType() {
		return bodyType;
	}

	/**
	 * @param bodyType the bodyType to set
	 */
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	/**
	 * @return the owner
	 */
	public Supplier getOwner() {
		return Owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Supplier owner) {
		Owner = owner;
	}

	public Car(int id, String make, String model, String trans, String engine, String color, int price, String desc, int year, int mil, String body, String var)
	{
	
		this.id=id;
		this.make=make;
		this.model=model;
		this.transmission=trans;
		this.EngineSize=engine;
		this.Colour=color;
		this.carPrice=price;
		this.desc=desc;
		this.yearModel=year;
		this.mileage = mil;
		this.variants = var;
		this.bodyType = body;
	}

	
}
