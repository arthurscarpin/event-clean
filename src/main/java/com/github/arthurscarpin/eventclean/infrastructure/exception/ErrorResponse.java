package com.github.arthurscarpin.eventclean.infrastructure.exception;

public record ErrorResponse(
        Integer statusCode,
        String message
) {
}
