package co.edu.uptc.models;

import java.awt.Color;
import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ColorSerializer implements JsonSerializer<Color> {

    @Override
    public JsonElement serialize(Color color, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.addProperty("r", color.getRed());
        result.addProperty("g", color.getGreen());
        result.addProperty("b", color.getBlue());
        result.addProperty("a", color.getAlpha());
        return result;
    }

}

