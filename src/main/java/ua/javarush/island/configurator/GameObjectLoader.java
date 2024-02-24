package ua.javarush.island.configurator;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import ua.javarush.island.annotations.Config;

import java.io.IOException;
import java.net.URL;

public class GameObjectLoader {
    private static GameObjectLoader instance;

    private GameObjectLoader() {
    }

    public static GameObjectLoader getInstance() {
        if (instance == null) {
            instance = new GameObjectLoader();
        }
        return instance;
    }

    public <T> T loadPrototype(Class<T> clazz) {
        return loadObject(getConfigFilePath(clazz), clazz);
    }

    private <T> T loadObject(URL configFilePath, Class<T> clazz) {
        YAMLMapper mapper = new YAMLMapper();
        T organism;
        try {
            organism = mapper.readValue(configFilePath, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return organism;
    }

    private URL getConfigFilePath(Class<?> clazz) {
        Config config = clazz.getAnnotation(Config.class);
        return clazz.getClassLoader().getResource(config.filePath());
    }
}
