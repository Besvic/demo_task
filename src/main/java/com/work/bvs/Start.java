package com.work.bvs;

import com.work.bvs.logic.Sort;
import com.work.bvs.logic.impl.SortImpl;
import com.work.bvs.logic.Input;
import com.work.bvs.logic.impl.InputImpl;

import java.util.List;
import java.util.stream.Collectors;

public class Start {
    private static final String PATH_TO_IN = "src/main/resources/in.txt";

    public static void main(String[] args) {
        Input input = new InputImpl();
        List<String> inputList = input.readFile(PATH_TO_IN);

        List<String[]> arr = inputList.stream()
                .filter(s -> !s.isEmpty())
                .map(s -> s.split("\t"))
                .collect(Collectors.toList());

        Sort s = new SortImpl();
        input.writeFile(s.sortedMessage(arr));

    }

}
