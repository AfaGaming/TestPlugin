package com.afa.testPlugin.Managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JsonManager {
    public void writeJson(String path, Object object) throws IOException {
        File file = new File(path);
        if (!file.exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        String json = gson.toJson(object);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    public Object readJson(File file, Class whatToRead, Boolean prettyFormat) throws IOException {
        if (file.exists()) {
            Gson gson = prettyFormat ? new GsonBuilder().setPrettyPrinting().create() : new Gson();
            FileReader reader = new FileReader(file);
            return gson.fromJson(reader, whatToRead);
        } else {
            throw new FileNotFoundException();
        }
    }
}