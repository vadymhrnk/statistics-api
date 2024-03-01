package com.example.statisticsapi.service.file;

import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(String filePath);
}
