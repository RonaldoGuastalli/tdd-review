package com.study.company.category;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {
    private Category category;

    @BeforeEach
    public void setUp() {
        category = new Category();
    }

    @Test
    void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
        final var expectedName = "Filmes";
        final var expectedDescription = "Categoria dos mais assitidos";
        final var expectedIsActive = true;
        final var expectedCategory = category.newCategory(expectedName, expectedDescription, expectedIsActive);
        Assertions.assertNotNull(expectedCategory);
        Assertions.assertNotNull(expectedCategory.getId());
        Assertions.assertEquals(expectedName, expectedCategory.getName());
        Assertions.assertEquals(expectedDescription, expectedCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, expectedCategory.isActive());
        Assertions.assertNotNull(expectedCategory.getCreatedAt());
        Assertions.assertNotNull(expectedCategory.getUpdatedAt());
        Assertions.assertNull(expectedCategory.getDeletedAt());
    }

    @Test
    void givenAInvalidNullName_whenCallNewCategoryAndValidate_thenShouldShowAException() {
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;
        CategoryException expectedCategory = Assertions.assertThrows(CategoryException.class, () ->
                category.newCategory(null, expectedDescription, expectedIsActive));
        Assertions.assertEquals(expectedCategory.getMessage(), expectedErrorMessage);
    }

    @Test
    void givenAInvalidEmptyName_whenCallNewCategoryAndValidate_thenShouldShowAException() {
        final String expectedName = " ";
        final var expectedErrorMessage = "'name' should not be empty";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;
        CategoryException expectedCategory = Assertions.assertThrows(CategoryException.class, () ->
                category.newCategory(expectedName, expectedDescription, expectedIsActive));
        Assertions.assertEquals(expectedCategory.getMessage(), expectedErrorMessage);
    }

    @Test
    void givenAInvalidNameLengthLessThan3_whenCallNewCategory_thenShouldShowAException() {
        final String expectedName = "Fi ";
        final var expectedErrorMessage = "'name' must be between 3 and 255 charcters";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;
        CategoryException expectedCategory = Assertions.assertThrows(CategoryException.class, () ->
                category.newCategory(expectedName, expectedDescription, expectedIsActive));
        Assertions.assertEquals(expectedCategory.getMessage(), expectedErrorMessage);
    }

    @Test
    void givenAInvalidNameLengthMoreThan255_whenCallNewCategory_thenShouldShowAException() {
        final var expectedName = "Tit ".repeat(500);
        final var expectedErrorMessage = "'name' must be between 3 and 255 charcters";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;
        CategoryException expectedCategory = Assertions.assertThrows(CategoryException.class, () ->
                category.newCategory(expectedName, expectedDescription, expectedIsActive));
        Assertions.assertEquals(expectedCategory.getMessage(), expectedErrorMessage);
    }
}