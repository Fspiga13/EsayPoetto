package com.easypoetto.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BeachResortFactory {
	
	private static BeachResortFactory singleton;

	private BeachResortFactory() {

	}

	public static BeachResortFactory getInstance() {
		if (singleton == null) {
			singleton = new BeachResortFactory();
		}
		return singleton;
	}
	
	
	private boolean convertBoolean(String value){
		
		if (value.equals("Y"))
			return true;
		return false;
		
	}
	
	public List<BeachResort> getBeachResorts() {
		
		List<BeachResort> beachResorts = new ArrayList<BeachResort>();
		
		try (Connection conn = DbManager.getInstance().getDbConnection(); Statement stmt = conn.createStatement())  {

			String sql = "select email, name, description, image, logo, address, telephone, num_umbrellas, "
					+ "num_beach_loungers, parking, pedalo, shower, toilette, restaurant, "
					+ "disabled_facilities, children_area, dog_area from beach_resorts, users where user_id = users.id";

			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				
				beachResorts.add(new BeachResort(result.getString("email"), result.getString("name"), result.getString("address"), 
						result.getString("telephone"), result.getString("description"), result.getString("image"), result.getString("logo"), 
						result.getInt("num_umbrellas"), result.getInt("num_beach_loungers"), convertBoolean(result.getString("parking")), 
						convertBoolean(result.getString("pedalo")), convertBoolean(result.getString("shower")), convertBoolean(result.getString("toilette")),
						convertBoolean(result.getString("restaurant")), convertBoolean(result.getString("disabled_facilities")), 
						convertBoolean(result.getString("children_area")), convertBoolean(result.getString("dog_area"))));
			}

			System.out.println("AAAA " + beachResorts.get(0).getName());
			return beachResorts;
					
		} catch (SQLException e) {
			Logger.getLogger(BeachResortFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("errore in getBeachResorts dentro BeachResortFactory");
		}	
		
		return null;
		
	}

}
