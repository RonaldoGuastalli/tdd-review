package com.study.company.category;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Category {
    private String id;
    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    public Category newCategory(final String name, final String description, final boolean isActive) {
        Category category = Category.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .description(description)
                .active(isActive)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .deletedAt(null)
                .build();
        validate(category);
        return category;
    }

    private void validate(final Category category) {
        checkNameConstraints(category);
    }

    private void checkNameConstraints(Category category) {
        if(category.getName() == null) {
            throw new CategoryException("'name' should not be null");
        }
        if(category.getName().isBlank()) {
            throw new CategoryException("'name' should not be empty");
        }
        final var length = category.getName().trim().length();
        if(length < 3 || length > 255 ) {
            throw new CategoryException("'name' must be between 3 and 255 charcters");
        }
    }
}
