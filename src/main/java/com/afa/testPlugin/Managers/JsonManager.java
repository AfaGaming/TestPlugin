package com.afa.testPlugin.Managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JsonManager {
    public void writeJson(File parentDirectory, String fileName, Object whatToWrite) throws IOException {
        File file = new File(parentDirectory, fileName);

        if (!parentDirectory.exists()) { parentDirectory.mkdirs(); }
        if (!file.exists()) { file.createNewFile(); }

        FileWriter writer = new FileWriter(file);
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        String json = gson.toJson(whatToWrite);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    public Object readJson(File file, Class whatToRead) throws IOException {
        if (file.exists()) {
            Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            FileReader reader = new FileReader(file);
            return gson.fromJson(reader, whatToRead);
        } else {
            throw new FileNotFoundException();
        }
    }
}