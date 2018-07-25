package com.beerek.test.service;

import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class ReaderServiceImpl implements ReaderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReaderServiceImpl.class);

    @Override
    public Optional<String> readByUrl(String url) {
        try {
            File file = ResourceUtils.getFile(String.format("classpath:%s/ok.json", url.substring(1)));

            return Optional.of(
                    String.join("\n",
                            Files.readLines(file, Charset.defaultCharset()))
            );
        } catch (IOException e) {
            LOGGER.warn("Exception during reading file!", e);

            return Optional.empty();
        }
    }
}
