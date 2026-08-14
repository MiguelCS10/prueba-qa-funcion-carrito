package com.example.automation.utils;

import com.example.automation.model.EmailConfirmation;

import java.util.Set;

public final class EmailConfirmationValidator {
    private static final Set<String> SUPPORTED_DOMAINS = Set.of("example.com", "test.com");
    private static final String AUTHORIZED_SENDER = "orders@mock-shop.test";

    private EmailConfirmationValidator() {
    }

    public static boolean hasSupportedRecipientDomain(EmailConfirmation email) {
        String[] parts = email.recipient().split("@", -1);
        return parts.length == 2 && SUPPORTED_DOMAINS.contains(parts[1].toLowerCase());
    }

    public static boolean hasAuthorizedSender(EmailConfirmation email) {
        return AUTHORIZED_SENDER.equalsIgnoreCase(email.sender());
    }

    public static boolean hasOrderInformation(EmailConfirmation email) {
        return !email.orderId().isBlank()
                && "CONFIRMED".equals(email.status())
                && email.total().signum() > 0
                && !email.items().isEmpty();
    }
}
