package com.afa.testPlugin.Managers;

import com.afa.testPlugin.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlManager {
    private Main main;
    public YamlManager(Main main) {
        this.main = main;
    }

    public YamlConfiguration getYamlFile(String name) throws IOException {
        File file = new File(main.getDataFolder(), name);
        if (!file.exists()) { file.createNewFile(); }

        YamlConfiguration configurableFile = YamlConfiguration.loadConfiguration(file);
        return configurableFile;
    }
}