package com.work.bvs.logic;

import java.util.List;

public interface Input {
    List<String> readFile(String path);
    void writeFile(List<String[]> arr);

}
