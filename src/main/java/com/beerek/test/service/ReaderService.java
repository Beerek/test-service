package com.beerek.test.service;

import java.util.Optional;

public interface ReaderService {

    Optional<String> readByUrl(String url);
}
