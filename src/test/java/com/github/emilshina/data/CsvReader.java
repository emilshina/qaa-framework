package com.github.emilshina.data;

import com.github.emilshina.utils.ReflectionUtils;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;

import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.ClassLoader.getSystemResource;

/**
 * Class for reading data from csv files.
 */

@Slf4j
public class CsvReader implements DataReader {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] readFrom(final String dataSource, final Class<T> entityClass) {
        return (T[]) Try.withResources(() -> Files.lines(Paths.get(getSystemResource(dataSource).getPath())))
                .of(stringStream -> StreamEx.of(stringStream)
                        .skip(1)
                        .map(line -> line.split(";"))
                        .map(data -> ReflectionUtils.getObject(entityClass, (Object[]) data))
                        .toArray())
                .getOrElseThrow(e -> new IllegalArgumentException("Unable to read " + dataSource, e));
    }

    @Override
    public String dataType() {
        return "csv";
    }
}
