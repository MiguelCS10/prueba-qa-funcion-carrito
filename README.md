# QA Automation - Funcion de carrito

Proyecto Maven pequeno para una prueba tecnica de QA sobre carrito de compras. La automatizacion queda preparada para conectarse a un ambiente real mas adelante, pero actualmente trabaja con contratos, datos y selectores `MOCK/TODO/PLACEHOLDER`.

No existe frontend real, API real, Oracle, URL real, DOM real, credenciales ni servicio de correo. Por eso no se reportan pedidos reales, respuestas reales, capturas ni correos entregados.

## Tecnologias

- Java 17
- Maven
- Selenium WebDriver
- TestNG
- REST Assured

No se usa JUnit.

## Estructura

```text
src
  main/java/com/example/automation
    api        Clientes REST Assured preparados para endpoints ficticios
    core       Configuracion, WebDriver y explicit waits
    model      Product, CartLine y EmailConfirmation
    pages      Page Objects con selectores TODO/PLACEHOLDER
    utils      Calculo monetario con BigDecimal, SQL y validaciones reutilizables
  test/java/com/example/automation
    api        Contratos MOCK y validacion futura de Oracle
    base       Setup/teardown Selenium con TestNG
    data       DataProvider y productos MOCK
    regression Flujo E2E preparado para ambiente real
    tests      Casos UI, total y correo
```

## Casos de prueba

- TC-01: Agregar producto mediante input/Enter. Preparado con Selenium POM y `DataProvider` para cantidades invalidas. Deshabilitado hasta tener DOM real.
- TC-02: Agregar producto mediante boton. Preparado con Selenium POM. Deshabilitado hasta tener DOM real.
- TC-03: Validar respuesta de adicion. Ejecutable como contrato MOCK con REST Assured `ResponseBuilder`, sin llamada de red.
- TC-04: Validar nombre, precio e imagen del producto. Preparado con Selenium POM. Deshabilitado hasta tener DOM real.
- TC-05: Disminuir/eliminar mediante input/Enter. Preparado con Selenium POM y `DataProvider`. Deshabilitado hasta tener DOM real.
- TC-06: Disminuir/eliminar mediante boton. Preparado con Selenium POM. Deshabilitado hasta tener DOM real.
- TC-07: Validar respuesta de disminucion/eliminacion. Ejecutable como contrato MOCK con REST Assured, sin llamada de red.
- TC-08: Validar total actualizado. Ejecutable como logica local MOCK usando `BigDecimal`; version UI deshabilitada hasta tener frontend real.
- TC-09: Confirmar pedido y evitar multiples confirmaciones simultaneas. UI preparada y deshabilitada; contrato MOCK de respuesta ejecutable sin red.
- TC-10: Persistencia del pedido en Oracle. SQL representativo preparado en `SqlQueries`; test deshabilitado porque requiere Oracle real.
- TC-11: No duplicidad de pedidos. SQL representativo preparado en `SqlQueries`; test deshabilitado porque requiere Oracle real.
- TC-12: Correo de confirmacion. Ejecutable como validacion MOCK de estructura/contenido; no envia ni valida entrega real.

## Endpoints ficticios

- `POST /api/v1/cart/items`
- `PATCH /api/v1/cart/items/{productId}`
- `DELETE /api/v1/cart/items/{productId}`
- `GET /api/v1/cart`
- `POST /api/v1/orders`
- `GET /api/v1/orders/{orderId}`

Los clientes `CartApiClient` y `OrderApiClient` estan listos para usar REST Assured contra un ambiente futuro, pero los tests actuales no los ejecutan contra Internet ni contra servicios inexistentes.

## SQL representativo

Las consultas conceptuales estan en `src/main/java/com/example/automation/utils/SqlQueries.java`:

- `CART_ITEMS_BY_CART_ID`
- `ORDER_BY_ID`
- `ORDER_ITEMS_BY_ORDER_ID`
- `ORDER_TOTAL_BY_ID`
- `DUPLICATED_ORDER_BY_USER_AND_CART`

No se conectan a Oracle y no hay assertions sobre strings SQL. Cuando exista ambiente, se deben ejecutar con parametros reales y validar result sets.

## Suite de regresion

La suite real de TestNG esta definida en:

- `testng.xml`
- `RegressionSuite.xml`

Incluye tests ejecutables MOCK y clases UI/E2E deshabilitadas con `enabled = false` solo cuando dependen de frontend, API u Oracle reales.

## Como ejecutar

Ejecutar compilacion y pruebas MOCK disponibles:

```bash
mvn test
```

Compilar sin ejecutar tests:

```bash
mvn test -DskipTests
```

Parametros configurables:

```bash
mvn test -Dbrowser=chrome -Dheadless=true -DbaseUrl=http://localhost:8080 -DapiBaseUrl=http://localhost:8080
```

## Reemplazo futuro de placeholders

- Cambiar `baseUrl` y `apiBaseUrl` por URLs reales del ambiente.
- Reemplazar selectores `TODO` por IDs estables o `data-testid` reales.
- Sustituir productos `MOCK` por fixtures controlados del ambiente.
- Ajustar contratos REST contra la especificacion real.
- Ejecutar SQL contra Oracle con parametros reales y limpieza de datos.
- Integrar servicio real de correo o mailbox de pruebas.
- Habilitar gradualmente tests UI/E2E cuando existan frontend y backend verificables.

## Notas de calidad

- Page Objects contienen interacciones; tests contienen escenarios y assertions.
- `DataProvider` cubre cantidades invalidas sin duplicar metodos.
- No se usa `Thread.sleep()`; la sincronizacion usa explicit waits.
- Los calculos de dinero usan `BigDecimal`, no `double`.
- No hay `MarkerTest` como sustituto de suite.
