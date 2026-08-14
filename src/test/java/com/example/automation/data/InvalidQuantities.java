package com.example.automation.data;

import org.testng.annotations.DataProvider;

public final class InvalidQuantities {
    private InvalidQuantities() {
    }

    @DataProvider(name = "invalidQuantities")
    public static Object[][] invalidQuantities() {
        return new Object[][]{
                {"0", "La cantidad debe ser mayor a cero"},
                {"-1", "La cantidad debe ser mayor a cero"},
                {"1.5", "La cantidad debe ser un numero entero"},
                {"abc", "La cantidad debe ser numerica"},
                {"@#$", "La cantidad debe ser numerica"},
                {"", "La cantidad es obligatoria"},
                {"999999999", "La cantidad supera el limite permitido"}
        };
    }
}
