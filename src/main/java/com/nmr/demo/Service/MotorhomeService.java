package com.nmr.demo.Service;

import com.nmr.demo.Model.Motorhome;
import com.nmr.demo.Repository.MotorhomeRepository;

import java.util.ArrayList;
import java.util.List;

public class MotorhomeService {
    MotorhomeRepository mr = new MotorhomeRepository();


    public List<Motorhome> readAllMotorhomes() {
        List <Motorhome> allMotorhomes = new ArrayList<>();
        allMotorhomes = mr.readAllMotorhome();
        return allMotorhomes;
    }
}
