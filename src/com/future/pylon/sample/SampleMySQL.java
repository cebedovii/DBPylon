package com.future.pylon.sample;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;

import com.future.pylon.client.PylonClient;
import com.future.pylon.db.DatabaseMapping;

public class SampleMySQL {

	public static void main(String[] args) {
		mySQLInsert();
		mySQLSelect();
		mySQLUpdate();
		mySQLDelete();
		mySQLGetColumnList();
	}

	public static void mySQLGetColumnList() {
		PylonClient client = new PylonClient(
				"http://localhost:8080/tmp/PylonController?",
				DatabaseMapping.DB_MYSQL, "sqlgateway", "Test1", "Test1");

		List<String> columnList = client.executeMySQLGetColumns("branches");

		System.out.println(columnList.toString());
	}

	public static void mySQLInsert() {
		PylonClient client = new PylonClient(
				"http://localhost:8080/tmp/PylonController?",
				DatabaseMapping.DB_MYSQL, "sqlgateway", "Test1", "Test1");

		String[] columnsAndValues = { "Name='Magallanes'", "BranchID=44",
				"Details='None'" };

		boolean success = client.executeMySQLInsert("branches",
				columnsAndValues);

		System.out.println(success);
	}

	public static void mySQLDelete() {
		PylonClient client = new PylonClient(
				"http://localhost:8080/tmp/PylonController?",
				DatabaseMapping.DB_MYSQL, "sqlgateway", "Test1", "Test1");

		String[] conditions = { "SaleID = 1417419495515", "Name = 'Pencil'" };

		boolean success = client.executeMySQLDelete("sales", conditions);

		System.out.println(success);
	}

	public static void mySQLUpdate() {
		PylonClient client = new PylonClient(
				"http://localhost:8080/tmp/PylonController?",
				DatabaseMapping.DB_MYSQL, "sqlgateway", "Test1", "Test1");

		String[] columnsAndValues = { "Name='Keyboard'", "Price = 100" };
		String[] conditions = { "Price < 150" };

		boolean success = client.executeMySQLUpdate("items", columnsAndValues,
				conditions);

		System.out.println(success);
	}

	public static void mySQLSelect() {
		PylonClient client = new PylonClient(
				"http://localhost:8080/tmp/PylonController?",
				DatabaseMapping.DB_MYSQL, "sqlgateway", "Test1", "Test1");

		List<Map<String, SimpleEntry<String, String>>> items = client
				.executeMySQLSelect("items", "SELECT * FROM items");

		System.out.println(items.toString());
	}
}
