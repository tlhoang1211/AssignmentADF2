import java.sql.*;

public class EmployeeModel {
    public boolean checkExistAccount(String account) throws SQLException {
        Statement statement = ConnectionHelper.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Employees");
        while (result.next()) {
            if (account.equals(result.getString("account"))) {
                System.out.println("Account already exists!");
                return true;
            }
        }
        return false;
    }

    public boolean register(Employee emp) throws SQLException {
        if (checkExistAccount(emp.getAccount())) {
            return false;
        }

        String query = "";
        Connection connection = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO `employess` (`name`, `address`, `email`, `account`, `password`, `createAt`, `updateAt`, `status`)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1,emp.getName());
        preparedStatement.setString(2,emp.getAddress());
        preparedStatement.setString(3,emp.getEmail());
        preparedStatement.setString(4,emp.getAccount());
        preparedStatement.setString(5,emp.getPassword());
        preparedStatement.setDate(6, (Date) emp.getCreateAt());
        preparedStatement.setDate(7, (Date) emp.getUpdateAt());
        preparedStatement.setInt(8,emp.getStatus());
        preparedStatement.execute();
        return true;
    }

    public Employee login(String account, String password) throws SQLException {
        Statement statement = ConnectionHelper.getConnection().createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM employees");
        while (result.next()) {
            if (account.equals(result.getString("account")) && password.equals(result.getString("password"))) {
                PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement("SELECT * FROM `employees WHERE `account` = ?" );
                preparedStatement.setString(1, account);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                System.out.println(resultSet.getString("account"));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getString(5));
                System.out.println(resultSet.getString(6));
                System.out.println(resultSet.getString(7));
                System.out.println(resultSet.getString(8));
            }
        }
        return null;
    }
}
