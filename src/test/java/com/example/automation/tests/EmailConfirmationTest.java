package com.example.automation.tests;

import com.example.automation.data.MockProducts;
import com.example.automation.model.CartLine;
import com.example.automation.model.EmailConfirmation;
import com.example.automation.utils.CartCalculator;
import com.example.automation.utils.EmailConfirmationValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class EmailConfirmationTest {
    @Test(description = "TC-12 - MOCK: Valida estructura conceptual del correo sin servicio real de email.")
    public void tc12ShouldValidateMockEmailConfirmationContent() {
        List<CartLine> items = List.of(
                new CartLine(MockProducts.LAPTOP, 1),
                new CartLine(MockProducts.HEADPHONES, 2)
        );
        BigDecimal expectedTotal = CartCalculator.expectedTotal(items);

        EmailConfirmation email = new EmailConfirmation(
                "qa.user@example.com",
                "orders@mock-shop.test",
                "MOCK-ORDER-7001",
                "CONFIRMED",
                expectedTotal,
                items
        );

        Assert.assertTrue(EmailConfirmationValidator.hasSupportedRecipientDomain(email));
        Assert.assertTrue(EmailConfirmationValidator.hasAuthorizedSender(email));
        Assert.assertTrue(EmailConfirmationValidator.hasOrderInformation(email));
        Assert.assertEquals(email.items().get(0).product().name(), MockProducts.LAPTOP.name());
        Assert.assertEquals(email.items().get(0).quantity(), 1);
        Assert.assertEquals(email.total(), new BigDecimal("1361.00"));
    }
}
