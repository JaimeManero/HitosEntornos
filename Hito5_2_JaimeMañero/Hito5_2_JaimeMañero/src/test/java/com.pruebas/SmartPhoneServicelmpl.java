package com.pruebas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public  class SmartPhoneServicelmpl {
    private SmartPhoneServicelmp SmartPhoneService;
    @BeforeEach
    public void setUp() {

        SmartPhoneService = new SmartPhoneServ();
    }

    @DisplayName("El método count() no devuelve NULL")
    @Test
    @Order(1)
    public void NoNull() {

        assertNotNull(SmartPhoneService.count());
    }

    @DisplayName("El valor devuelto es mayor que cero")
    @Test
    @Order(2)
    public void MayorCero() {

        assertTrue(SmartPhoneService.count() > 0);
    }

    @DisplayName("El valor devuelto es tres")
    @Test
    @Order(3)
    public void DevolucionTres() {

        assertEquals(3, SmartPhoneService.count());
    }

    @DisplayName("El método findOne() lanza IllegalArgumentException cunado el ID es nulo")
    public void FindOne() {
        assertThrows(IllegalArgumentException.class, () -> SmartPhoneService.findOne(null));
    }

    @DisplayName("las aserciones deben ejecutarse independientemente")
    public void testTotalAssertions() {
        assertAll("total",
                () -> assertNotNull(SmartPhoneService.count()),
                () -> assertTrue(SmartPhoneService.count() > 0),
                () -> assertEquals(3, SmartPhoneService.count())
        );
    }
}

