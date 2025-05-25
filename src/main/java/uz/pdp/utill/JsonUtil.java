package uz.pdp.utill;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> void writeGson(String path, T t) {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File(path);

        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            boolean dirsCreated = parentDir.mkdirs();
            if (!dirsCreated) {
                System.err.println("Kataloglar yaratishda muammo bo'ldi: " + parentDir.getAbsolutePath());
            }
        }

        try {
            objectMapper.writeValue(file, t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static <T> T readGson(String resourcePath, TypeReference<T> typeReference) {
        try (InputStream inputStream = JsonUtil.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + resourcePath);
            }
            return objectMapper.readValue(inputStream, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
