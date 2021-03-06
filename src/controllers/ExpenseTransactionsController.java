package controllers;

import java.sql.*;

public class ExpenseTransactionsController extends DBController {
	private Connection con = connect();
	
	public void createTable() {
		try {
			con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS expense_transactions (id int(10) UNSIGNED AUTO_INCREMENT," +
					" total_amount double, amount_paid double, balance double, method_of_payment varchar(45), discount double," +
					" payment_id int(10), user_id int(10), approved varchar(45), created_at datetime, updated_at datetime, primary key(id))ENGINE = InnoDB");
		} catch (SQLException e) {}
	}
}
