package com.raysi.springdatajpamapping.error;


public record ErrorMessage(
        String errorMessage,
        String errorCode
) {
}
