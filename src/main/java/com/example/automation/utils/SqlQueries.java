package com.example.automation.utils;

public final class SqlQueries {
    /*
     * MOCK/TODO/PLACEHOLDER:
     * These SQL statements document the future Oracle validation strategy.
     * They must be reviewed against the real schema before execution.
     */
    public static final String CART_ITEMS_BY_CART_ID = """
            SELECT
                product_id,
                quantity,
                unit_price
            FROM CART_ITEMS
            WHERE cart_id = :cartId
            """;

    public static final String ORDER_BY_ID = """
            SELECT
                order_id,
                user_id,
                total,
                order_date,
                status
            FROM ORDERS
            WHERE order_id = :orderId
            """;

    public static final String ORDER_ITEMS_BY_ORDER_ID = """
            SELECT
                product_id,
                quantity,
                unit_price
            FROM ORDER_ITEMS
            WHERE order_id = :orderId
            """;

    public static final String ORDER_TOTAL_BY_ID = """
            SELECT
                SUM(quantity * unit_price) AS calculated_total
            FROM ORDER_ITEMS
            WHERE order_id = :orderId
            """;

    public static final String DUPLICATED_ORDER_BY_USER_AND_CART = """
            SELECT
                user_id,
                cart_id,
                COUNT(*) AS duplicate_count
            FROM ORDERS
            WHERE user_id = :userId
              AND cart_id = :cartId
            GROUP BY user_id, cart_id
            HAVING COUNT(*) > 1
            """;

    private SqlQueries() {
    }
}
