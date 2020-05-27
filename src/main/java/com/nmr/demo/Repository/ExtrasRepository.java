package com.nmr.demo.Repository;

import com.nmr.demo.Model.Extras;
import com.nmr.demo.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExtrasRepository implements IExtrasRepository{

    private Connection conn;
    private PreparedStatement preparedStatement;

    public ExtrasRepository(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public List<Extras> readAllExtras() {
        List <Extras> allExtras = new ArrayList<>();
        try {
            String getAllExtras =
                    "SELECT * FROM nmr.extras_table";
            PreparedStatement myStatement = conn.prepareStatement(getAllExtras);
            ResultSet rs = myStatement.executeQuery();
            while (rs.next()) {
                allExtras.add(new Extras(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allExtras;
    }
}
