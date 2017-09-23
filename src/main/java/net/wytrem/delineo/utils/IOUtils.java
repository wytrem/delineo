package net.wytrem.delineo.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;


public class IOUtils {
    public static final String toString(InputStream stream) {
        return new BufferedReader(new InputStreamReader(stream)).lines()
                                                                .collect(Collectors.joining("\n"));
    }
}
