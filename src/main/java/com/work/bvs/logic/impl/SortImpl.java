package com.work.bvs.logic.impl;

import com.work.bvs.logic.Sort;
import com.work.bvs.validate.Valid;

import java.util.List;

public class SortImpl implements Sort {

    @Override
    public List<String[]> sortedMessage(List<String[]> array) {
        array.sort((o1, o2) -> extracted(o1, o2, 0));
        return array;
    }

    private int extracted(String[] o1, String[] o2, int i) {
        int value = 0;
        if (Valid.isNumber(o1[i]) && Valid.isNumber(o2[i])){
            value = Double.compare(Double.parseDouble(o1[i]), Double.parseDouble(o2[i]));
        } else{
            value = o1[i].compareTo(o2[i]);
        }
        if (value == 0){
            value = extracted(o1, o2, ++i);
        }
        return value;
    }
}
