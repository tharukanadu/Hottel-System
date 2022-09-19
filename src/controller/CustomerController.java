package controller;

import Save.SaveCustomer;
import db.DBUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modul.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController {
    public TextField textCustomerId;
    public TextField textCustomerName;
    public TextField textAddress;
    public TextField textCustomerNumber;
    public TextField textCustomerEmail;


    public void CustomerSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            Customer customer = new Customer(textCustomerId.getText(), textCustomerName.getText(), textAddress.getText(), textCustomerNumber.getText(), textCustomerEmail.getText());
            boolean isSave = SaveCustomer.saveCustomer(customer);
            if (isSave) {
                new Alert(Alert.AlertType.INFORMATION, "Success").show();

            } else {
                new Alert(Alert.AlertType.ERROR, "Error").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    public void CustomerDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getInstance().getCon();
        PreparedStatement pstm = con.prepareStatement("DELETE FROM customer WHERE id=?");
        pstm.setObject(1,textCustomerId.getText());
        boolean isDelete = pstm.executeUpdate() > 0;
        if (isDelete){
            new Alert(Alert.AlertType.CONFIRMATION,"Delete").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again").show();

        }
    }

    public void CustomerUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Customer customer = new Customer(
                textCustomerId.getText(),
                textCustomerName.getText(),
                textAddress.getText(),
                textCustomerNumber.getText(),
                textCustomerEmail.getText()
        );


        if (new SaveCustomer().updateCustomer(customer))
            new Alert(Alert.AlertType.CONFIRMATION, "Updated..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again").show();


    }

    public void SearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection con = DBUtil.getInstance().getCon();
        PreparedStatement pstm = con.prepareStatement("SELECT * FROM customer WHERE id='" + textCustomerId.getText() + "'");
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {

            textCustomerName.setText(rst.getString(2));
            textAddress.setText(rst.getString(3));
            textCustomerNumber.setText(rst.getString(4));
            textCustomerEmail.setText(rst.getString(5));

        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        }

    }
}