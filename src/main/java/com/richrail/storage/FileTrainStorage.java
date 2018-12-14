package com.richrail.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.richrail.domain.Train;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileTrainStorage implements TrainStorage {
    String fileLocation;
    Gson gson;

    public FileTrainStorage(String fileLocation) {
        this.gson = new Gson();
        this.fileLocation = fileLocation;
    }

    private String loadJsonFile() {
        String json = "";
        try {
            json = new String(Files.readAllBytes(Paths.get(fileLocation)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private void writeJsonFile(String json) {
        try {
            Files.write(Paths.get(fileLocation), json.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Train> loadTrains() {
        Type type = new TypeToken<List<Train>>() {
        }.getType();

        return gson.fromJson(loadJsonFile(), type);
    }

    @Override
    public void saveTrains(List<Train> trains) {
        writeJsonFile(gson.toJson(trains));
    }
}
