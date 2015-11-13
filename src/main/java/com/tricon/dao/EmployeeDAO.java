package com.tricon.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tricon.utilities.DBConnection;
import com.tricon.vo.Division;
import com.tricon.vo.Employee;

public class EmployeeDAO {
	public boolean create(Employee employee) {

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
			pst.setBoolean(12, employee.isEnabled());
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

		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int rowsRead = 0;

		try {
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getInstance();
			pst = conn.prepareStatement("select * from employee where id=?");

			rs = pst.executeQuery();
			rs.last();
			rowsRead = rs.getRow();

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
		if (rowsRead > 0) {
			status = true;
		}
		return status;
	}

	public boolean udpate(Employee employee) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		int rowsUpdated = 0;

		try {
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getInstance();
			pst = conn.prepareStatement(
					"update employee set lastName=?, firstName=?, address=?, zipcode=?, city=?, state=?, country=?, id=?, date=?, employeeType=?, divId=?, enabled=?, createdBy=?, updatedBy=?, createdAt=?, updatedAt=? where id=?");
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
			pst.setBoolean(12, employee.isEnabled());
			pst.setString(13, employee.getCreatedBy());
			pst.setString(14, employee.getUpdatedBy());
			pst.setDate(15, new Date(employee.getCreatedAt().getTime()));
			pst.setDate(16, new Date(employee.getUpdatedAt().getTime()));
			pst.setLong(17, employee.getId());

			rowsUpdated = pst.executeUpdate();

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
		if (rowsUpdated > 0) {
			status = true;
		}
		return status;
	}

	public boolean delete(Employee employee) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		int rowsDeleted = 0;

		try {
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getInstance();
			pst = conn.prepareStatement("delete from employee where id=?");

			pst.setLong(1, employee.getId());

			rowsDeleted = pst.executeUpdate();

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
		if (rowsDeleted > 0) {
			status = true;
		}
		return status;
	}

	public List<Employee> getAllEmployees() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp;
        int count = 0;
		try {
			DBConnection dbconnection = new DBConnection();
			conn = dbconnection.getInstance();
			pst = conn.prepareStatement("select * from employee");

			rs = pst.executeQuery();

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
		try{
		while (rs.next()){
			emp=new Employee();
			emp.setLastName(rs.getString(1));
			emp.setFirstName(rs.getString(2));
			emp.setAddress(rs.getString(3));
			emp.setZipcode(rs.getString(4));
			emp.setCity(rs.getString(5));
			emp.setState(rs.getString(6));
			emp.setCountry(rs.getString(7));
			emp.setId(rs.getLong(8));
			emp.setDate(rs.getDate(9));
			emp.setEmployeeType(rs.getString(10));
			Division div = new Division();
			div.setId(rs.getLong(11));
			emp.setDivision(div);
			emp.setEnabled(rs.getBoolean(12));
			emp.setCreatedBy(rs.getString(13));
			emp.setUpdatedBy(rs.getString(14));
			emp.setCreatedAt(rs.getDate(15));
			emp.setUpdatedAt(rs.getDate(16));
			empList.add(emp);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return empList;
	}
}
