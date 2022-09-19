package Save;

import controller.CustomerService;
import db.DBUtil;
import modul.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveCustomer {

    public static boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getInstance().getCon();
        PreparedStatement pstm = con.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?)");
        pstm.setObject(1,customer.getId());
        pstm.setObject(2,customer.getName());
        pstm.setObject(3,customer.getAddress());
        pstm.setObject(4,customer.getT_number());
        pstm.setObject(5,customer.getEmail());

        return pstm.executeUpdate()>0;

    }
    public boolean updateCustomer (Customer customer) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBUtil.getInstance().getCon().prepareStatement("UPDATE customer SET  name=?, address=?,t_number=?,email=? WHERE id=?");
        stm.setObject(1,customer.getName());
        stm.setObject(2,customer.getAddress());
        stm.setObject(3,customer.getT_number());
        stm.setObject(4,customer.getEmail());
        stm.setObject(5,customer.getId());

        return stm.executeUpdate()>0;
    }
}
