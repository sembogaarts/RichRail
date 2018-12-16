package com.richrail.serializer;

import com.google.gson.*;
import com.richrail.RollingComponentType;
import com.richrail.builder.RollingComponentBuilder;
import com.richrail.domain.RollingComponent;

import java.lang.reflect.Type;

public class RollingComponentSerializer implements JsonSerializer<RollingComponent>, JsonDeserializer<RollingComponent> {

    @Override
    public JsonElement serialize(RollingComponent src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", src.getId());

        jsonObject.addProperty("type", RollingComponentType.getTypeByInstance(src).getType());

        return jsonObject;

    }

    @Override
    public RollingComponent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String rollingComponentType = jsonObject.get("type").getAsString();
        String rollingComponentId = jsonObject.get("id").getAsString();

        return new RollingComponentBuilder()
                .setType(RollingComponentType.getTypeByText(rollingComponentType))
                .setId(rollingComponentId)
                .build();
    }
}
