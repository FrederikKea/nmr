package com.nmr.demo.Repository;


import com.nmr.demo.Model.Extras;
import com.nmr.demo.Model.Motorhome;

import java.util.List;

public interface IMotorhomeRepository {

    List<Motorhome> readAllMotorhome();
}
