package dao;

import model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
    public MemberDAO() {}

    public boolean logInValidate(String username, String password) {
        try {
            String query = "select * from ClassManagement.reader where username = \'" + username + "\';";
            ResultSet resultSet = executeQuery(query);
            if (resultSet.next()) {
                System.out.println("hehehe" + resultSet.getString("password"));
                return resultSet.getString("password").equals(password);
            }

        } catch (SQLException e) {
            System.out.println("hehehe" + e.toString());
        }

        return false;
    }
    public Member getMemberByUsername(String username) {
        String query = "select * from ClassManagement.reader where username = \'" + username + "\';";
        ResultSet resultSet = executeQuery(query);
        try {
            if (resultSet.next()) {
                return new Member(
                        1,
                        resultSet.getString("username"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("address"),
                        resultSet.getString("telephone"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private ResultSet executeQuery(String query) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)
                    initContext.lookup("java:comp/env");
            DataSource ds = (DataSource)
                    envContext.lookup("jdbc/ClassManagement");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();

            return statement.executeQuery(query);
        } catch (NamingException|SQLException e) {
            return null;
        }
    }

    public boolean isUnique(String username) {
        String query = "SELECT 1 FROM ClassManagement.reader WHERE username = '" + username + "';";
        ResultSet resultSet = executeQuery(query);
        try {
            return !resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean registerSuccessfully(
            String username,
            String firstName,
            String lastName,
            String address,
            String phoneNumber,
            String email,
            String password
    ) {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)
                    initContext.lookup("java:comp/env");
            DataSource ds = (DataSource)
                    envContext.lookup("jdbc/ClassManagement");
            Connection connection = ds.getConnection();
            String query = " insert into ClassManagement.reader"
                    + " values (null, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, username);
            preparedStmt.setString (2, firstName);
            preparedStmt.setString (3, lastName);
            preparedStmt.setString (4, address);
            preparedStmt.setString (5, phoneNumber);
            preparedStmt.setString (6, email);
            preparedStmt.setString (7, password);
            preparedStmt.execute();
            return true;
        } catch (NamingException|SQLException e) {
            return false;
        }
    }
}