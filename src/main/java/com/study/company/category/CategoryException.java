package com.study.company.category;

public class CategoryException extends RuntimeException {

    public CategoryException(String message) {
        super(message, null, true, false);
    }
}
