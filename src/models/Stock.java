package models;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import controllers.StocksController;

public class Stock {
	private String name;
	private int quantity;
	private String units;
	private double buyingPrice;
	private double sellingPrice;
	private String time;
	private static StocksController controller = new StocksController();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}	
	
	// CRUD operations
	
	public static Map<String, String> find(String id) {
		return controller.show("stocks", id);		
	}
	
	public static List<Map<String, String>> where(String field, String value) {
		return controller.conditionalSelect("stocks", field, value);		
	}
	
	public static List<Map<String, String>> where(String conditions) {
		return controller.conditionalSelect("stocks", conditions);		
	}

	public static Map<String, String> create(TreeMap<String, String> params) {
		return controller.create("stocks", params);		
	}


	public static List<TreeMap<String, String>> showAll() {
		return controller.index("stocks");		
	}

	public static boolean update(Map<String, String> params, Map<String, String> conditions) {
		for(String field : conditions.keySet()) {
			controller.update("stocks", params, field, conditions.get(field));
		}
		return false;		
	}

	public static boolean delete(String id) {
		controller.delete("stocks", id);
		return false;		
	}

	public static boolean deleteAll() {
		controller.truncate("stocks");
		return false;		
	}
	
	public static boolean exists(String id, String value) {
		return controller.recordExists("stocks", id, value);
	}
	
	public static List<String> columns() {
		return controller.columns("stocks");
	}

	// Associations
	
	public static List<Map<String, String>> sales(String stockId) {
		return Sale.where("stock_id", stockId);		
	}
	
	// Migrations
	
	public static void migrate() {
		controller.createTable();
	}
}