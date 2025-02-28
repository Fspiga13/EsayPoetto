package com.easypoetto.model;

public class BeachResort {

	private int id;
	private String email;
	private String name;
	private String address;
	private String telephone;
	private String description;
	private String image;
	private String logo;
	private int numUmbrellas;
	private double priceUmbrella;
	private int numBeachLoungers;
	private double priceBeachLounger;
	private boolean parking;
	private boolean pedalo;
	private boolean shower;
	private boolean toilette;
	private boolean restaurant;
	private boolean disabledFacilities;
	private boolean childrenArea;
	private boolean dogArea;
	
	private int availableUmbrellas;
	private int availableBeachLoungers;

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param logo
	 * @param parking
	 * @param pedalo
	 * @param shower
	 * @param toilette
	 * @param restaurant
	 * @param disabledFacilities
	 * @param childrenArea
	 * @param dogArea
	 */
	public BeachResort(int id, String name, String address, String logo, boolean parking, boolean pedalo,
			boolean shower, boolean toilette, boolean restaurant, boolean disabledFacilities, boolean childrenArea,
			boolean dogArea) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.logo = logo;
		this.parking = parking;
		this.pedalo = pedalo;
		this.shower = shower;
		this.toilette = toilette;
		this.restaurant = restaurant;
		this.disabledFacilities = disabledFacilities;
		this.childrenArea = childrenArea;
		this.dogArea = dogArea;
	}

	/**
	 * @param id
	 * @param email
	 * @param name
	 * @param address
	 * @param telephone
	 * @param description
	 * @param image
	 * @param logo
	 * @param numUmbrellas
	 * @param priceUmbrella
	 * @param numBeachLoungers
	 * @param priceBeachLounger
	 * @param parking
	 * @param pedalo
	 * @param shower
	 * @param toilette
	 * @param restaurant
	 * @param disabledFacilities
	 * @param childrenArea
	 * @param dogArea
	 */
	public BeachResort(int id, String email, String name, String description, String image, String logo, String address,
			String telephone, int numUmbrellas, double priceUmbrella, int numBeachLoungers, double priceBeachLounger,
			boolean parking, boolean pedalo, boolean shower, boolean toilette, boolean restaurant,
			boolean disabledFacilities, boolean childrenArea, boolean dogArea) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.description = description;
		this.image = image;
		this.logo = logo;
		this.numUmbrellas = numUmbrellas;
		this.priceUmbrella = priceUmbrella;
		this.numBeachLoungers = numBeachLoungers;
		this.priceBeachLounger = priceBeachLounger;
		this.parking = parking;
		this.pedalo = pedalo;
		this.shower = shower;
		this.toilette = toilette;
		this.restaurant = restaurant;
		this.disabledFacilities = disabledFacilities;
		this.childrenArea = childrenArea;
		this.dogArea = dogArea;
	}	
	

	/**
	 * @param id
	 * @param name
	 * @param priceUmbrella
	 * @param priceBeachLounger
	 */
	public BeachResort(int id, String name, double priceUmbrella, double priceBeachLounger, int availableUmbrellas, int availableBeachLoungers) {
		this.id = id;
		this.name = name;
		this.priceUmbrella = priceUmbrella;
		this.priceBeachLounger = priceBeachLounger;
		this.availableUmbrellas = availableUmbrellas;
		this.availableBeachLoungers = availableBeachLoungers;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @return the numUmbrellas
	 */
	public int getNumUmbrellas() {
		return numUmbrellas;
	}

	/**
	 * @return the numBeachLoungers
	 */
	public int getNumBeachLoungers() {
		return numBeachLoungers;
	}

	/**
	 * @return the parking
	 */
	public boolean isParking() {
		return parking;
	}

	/**
	 * @return the pedalo
	 */
	public boolean isPedalo() {
		return pedalo;
	}

	/**
	 * @return the shower
	 */
	public boolean isShower() {
		return shower;
	}

	/**
	 * @return the toilette
	 */
	public boolean isToilette() {
		return toilette;
	}

	/**
	 * @return the restaurant
	 */
	public boolean isRestaurant() {
		return restaurant;
	}

	/**
	 * @return the disabledFacilities
	 */
	public boolean isDisabledFacilities() {
		return disabledFacilities;
	}

	/**
	 * @return the childrenArea
	 */
	public boolean isChildrenArea() {
		return childrenArea;
	}

	/**
	 * @return the dogArea
	 */
	public boolean isDogArea() {
		return dogArea;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the priceUmbrella
	 */

	public double getPriceUmbrella() {
		return priceUmbrella;
	}

	/**
	 * @return the priceBeachLounger
	 */

	public double getPriceBeachLounger() {
		return priceBeachLounger;
	}

	/**
	 * @return the availableUmbrellas
	 */
	public int getAvailableUmbrellas() {
		return availableUmbrellas;
	}


	/**
	 * @return the availableBeachLoungers
	 */
	public int getAvailableBeachLoungers() {
		return availableBeachLoungers;
	}


}
