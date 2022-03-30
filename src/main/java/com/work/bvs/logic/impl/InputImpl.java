package com.work.bvs.logic.impl;

import com.work.bvs.logic.Input;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class InputImpl implements Input {
    @Override
    public List<String> readFile(String path) {
        try (Stream stream = Files.lines(Paths.get(path))) {
            return (List<String>) stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void writeFile(List<String[]> arr) {
        Path path = Paths.get("src/main/resources/out.txt");
        try {
            Files.write(path, Collections.singleton(createMessage(arr)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createMessage(List<String[]> array) {
        StringBuilder message = new StringBuilder();
        array.forEach(str -> {
            StringBuilder innerString = new StringBuilder();
            Arrays.stream(str).forEach(inner -> innerString
                    .append(inner)
                    .append("\t"));
            message.append(innerString)
                    .append("\n");
        });
        return message.toString();
    }

}
