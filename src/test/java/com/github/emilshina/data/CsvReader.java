package com.github.emilshina.data;

import com.github.emilshina.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class for reading data from csv files.
 */

@Slf4j
public class CsvReader implements DataReader {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] readFrom(String dataSource, Class<T> entityClass) {
        final String path = ClassLoader.getSystemResource(dataSource).getPath();
        final List<T> objects;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            objects = StreamEx.of(stream)
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(data -> ReflectionUtils.getObject(entityClass, (Object[]) data))
                    .toList();
        } catch (IOException ex) {
            throw new IllegalArgumentException("Unable to read " + dataSource, ex);
        }
        return (T[]) objects.toArray();
    }

    @Override
    public String dataType() {
        return "csv";
    }
}
