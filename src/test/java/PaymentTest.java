import org.example.Payment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
class PaymentTest {
    @Test
    public void testEqualsandHashCode(){
        Payment payment1 = new Payment("John Doe", 10, 11, 2023, 5000);
        Payment payment2 = new Payment("John Doe", 10, 11, 2023, 5000);
        Payment payment3 = new Payment("Will Smith", 15, 11, 2023, 7500);

        assertEquals(payment1, payment2);
        assertNotEquals(payment1, payment3);

    }

    @Test
    public void testToString() {
        Payment payment = new Payment("John Doe", 10, 11, 2023, 5000);
        String expected = "Payment{fullName='John Doe', day=10, month=11, year=2023, sumPayment=5000}";
        assertEquals(expected, payment.toString());
    }

}