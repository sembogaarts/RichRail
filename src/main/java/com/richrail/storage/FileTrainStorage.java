package com.richrail.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.richrail.domain.RollingComponent;
import com.richrail.domain.Train;
import com.richrail.serializer.RollingComponentSerializer;

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
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(RollingComponent.class, new RollingComponentSerializer());
        this.gson = gsonBuilder.create();
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
            Files.write(Paths.get(fileLocation), json.getBytes());
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
