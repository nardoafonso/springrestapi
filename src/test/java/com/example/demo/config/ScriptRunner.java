package com.example.demo.config;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScriptRunner {

    private final List<String> lines;

    public ScriptRunner(File file, String encoding) throws IOException {
        this.lines = FileUtils.readLines(file, encoding);
    }

    public void run(EntityManager entityManager) {
        for (String line : lines) {
            if (!line.startsWith("--") && !StringUtils.isBlank(line)) {
                entityManager.createNativeQuery(line).executeUpdate();
            }
        }
    }

}
