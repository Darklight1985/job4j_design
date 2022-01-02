package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
          StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader buff = new BufferedReader(new FileReader(cachingDir + key))) {
            while (buff.ready()) {
             stringBuilder.append(buff.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuilder);
    }

}