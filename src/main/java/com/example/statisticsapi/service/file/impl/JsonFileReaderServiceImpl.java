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

    public static final String READ_ERROR_MESSAGE = "Can't read from file: %s";
    public static final String EMPTY_STRING = "";
    public static final String SPACE_REGEX = "\\s+";

    @Override
    public List<String> readFromFile(String filePath) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line.trim().replaceAll(SPACE_REGEX, EMPTY_STRING));
            }

            return Collections.singletonList(jsonContent.toString());
        } catch (IOException e) {
            throw new RuntimeException(READ_ERROR_MESSAGE.formatted(filePath), e);
        }
    }
}
