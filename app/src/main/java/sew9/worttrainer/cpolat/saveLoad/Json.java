package sew9.worttrainer.cpolat.saveLoad;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    private final ObjectMapper mapper;

    public Json() {
        mapper = new ObjectMapper();
    }

    public void serialize(Object object, File file) throws Exception {
        mapper.writeValue(file, object);
    }

    public <T> T deserialize(File file, Class<T> type) throws Exception {
        return mapper.readValue(file, type);

    }

    public <T> T deserialize(String path, Class<T> type) throws Exception {
        return deserialize(new File(path), type);
    }

    public void serialize(Object object, String path) throws Exception {
        serialize(object, new File(path));
    }
}
