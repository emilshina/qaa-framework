package com.github.emilshina.data;

import com.github.emilshina.utils.JsonParserUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import io.vavr.control.Try;

import java.io.FileReader;

import static java.lang.ClassLoader.getSystemResource;

/**
 * Class for reading data from json files.
 */

public class JsonReader implements DataReader {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] readFrom(final String dataSource, final Class<T> entityClass) {

        return Try.withResources(() -> new com.google.gson.stream.JsonReader(new FileReader(
                getSystemResource(dataSource).getPath())))
                .of(reader -> new JsonParser().parse(reader))
                .mapTry(jsonElement -> JsonParserUtils.fromJsonAsArray(new Gson(), jsonElement, entityClass))
                .getOrElseThrow(e -> new IllegalArgumentException("Unable to read " + dataSource, e));
    }

    @Override
    public String dataType() {
        return "json";
    }
}
