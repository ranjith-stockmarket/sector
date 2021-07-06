package com.stockmarket.sector.Helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class ServiceResponse{
    private final HttpStatus status;
    private final Object body;

    public ResponseEntity<Object> getResponse() {
        return ResponseEntity.status(status).body(body);
    }

    public ResponseEntity<Object> getResponse(HttpHeaders httpHeaders) {
        return ResponseEntity.status(status).headers(httpHeaders).body(body);
    }
}
