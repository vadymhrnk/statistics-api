package com.example.statisticsapi.service.file.impl;

import com.example.statisticsapi.service.file.FileReaderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JsonFileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line.trim().replaceAll("\\s+", ""));
            }

            return Collections.singletonList(jsonContent.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: %s".formatted(filePath), e);
        }
    }
}
