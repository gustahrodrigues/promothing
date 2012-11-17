package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Product extends Model {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    public String id;

	@Constraints.Required
	public String name;
	public String description;
	public String bar_code;
	public double price;	
	
	public static Finder<String,Product> find = new Finder<String,Product>(String.class, Product.class);
		
	@Override
	public String toString() {
		return  "Id				: " + id 						+ "\n" +
				"Name			: " + name 						+ "\n" +
				"Description	: " + description 				+ "\n" +
				"BarCode		: " + String.valueOf(bar_code) 	+ "\n" +
				"Price			: " + price						+ "\n";			
	} 
	
	public boolean deveSalvar(){
		return name != null && description != null && bar_code != null && price != 0;
	}
}
