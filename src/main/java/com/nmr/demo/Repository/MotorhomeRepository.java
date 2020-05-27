package com.nmr.demo.Repository;

import com.nmr.demo.Model.Motorhome;
import com.nmr.demo.Util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeRepository {

    private Connection conn;
    private PreparedStatement preparedStatement;

    public MotorhomeRepository(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    public List<Motorhome> readAllMotorhome() {
        List <Motorhome> allMotorhomes = new ArrayList<>();
        try {
            String getAllMotorhomes =
                    "SELECT motorhome_table.motorhome_modelname, motorhome_table.motorhome_price\n" +
                            "FROM nmr.motorhome_table";
            PreparedStatement myStatement = conn.prepareStatement(getAllMotorhomes);
            ResultSet rs = myStatement.executeQuery();
            while (rs.next()) {
                allMotorhomes.add(new Motorhome(
                        rs.getString(1),
                        rs.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allMotorhomes;
    }
}
