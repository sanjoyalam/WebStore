package com.tricon.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tricon.utilities.DBConnection;
import com.tricon.vo.Employee;

public class EmployeeDAO {
	public boolean create(Employee employee) {
		boolean success = false;

		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		int count = 0;

		try {
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getInstance();
			pst = conn.prepareStatement(
					"insert into employee (lastName, firstName, address, zipcode, city, state, country, id, date, employeeType, divId, enabled, createdBy, updatedBy, createdAt, updatedAt) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, employee.getLastName());
			pst.setString(2, employee.getFirstName());
			pst.setString(3, employee.getAddress());
			pst.setString(4, employee.getZipcode());
			pst.setString(5, employee.getCity());
			pst.setString(6, employee.getState());
			pst.setString(7, employee.getCountry());
			pst.setLong(8, employee.getId());
			pst.setDate(9, new Date(employee.getDate().getTime()));
			pst.setString(10, employee.getEmployeeType());
			pst.setLong(11, employee.getDivision().getId());
			if (employee.isEnabled()) {
				pst.setInt(12, 1);
			} else {
				pst.setInt(12, 0);
			}
			pst.setString(13, employee.getCreatedBy());
			pst.setString(14, employee.getUpdatedBy());
			pst.setDate(15, new Date(employee.getCreatedAt().getTime()));
			pst.setDate(16, new Date(employee.getUpdatedAt().getTime()));

			count = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (count > 0) {
			status = true;
		}
		return status;
	}

	public boolean read(long id) {
		boolean success = false;

		return false;
	}

	public boolean udpate(Employee employee) {
		boolean success = false;

		return false;
	}

	public boolean delete(Employee employee) {
		boolean success = false;

		return false;
	}

	public List<Employee> getAllEmployees() {

	}
}
