package com.nmr.demo.Service;

import com.nmr.demo.Model.Extras;
import com.nmr.demo.Repository.ExtrasRepository;

import java.util.ArrayList;
import java.util.List;

public class ExtrasService {

    ExtrasRepository er = new ExtrasRepository();

    public List<Extras> readAllExtras() {
        List<Extras> allExtras = new ArrayList<>();
        allExtras = er.readAllExtras();
        return allExtras;
    }
}
