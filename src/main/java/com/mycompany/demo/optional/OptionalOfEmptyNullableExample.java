package com.mycompany.demo.optional;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

public class OptionalOfEmptyNullableExample {

    static Optional<String> ofNullable() {
        return Optional.ofNullable("Hello");
    }

    static Optional<String> of() {
        return Optional.of("Hello");
    }

    static Optional<String> empty() {
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println(ofNullable().isPresent());
        System.out.println(of());
        System.out.println(empty());
    }
}
