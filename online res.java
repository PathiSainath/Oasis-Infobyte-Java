import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Reservation {
    // ...rest of the code remains the same...
}

class User {
    // ...rest of the code remains the same...
}

class ReservationSystem {
    // ...rest of the code remains the same...
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();

        // Add users
        reservationSystem.addUser(1, "John Doe", "john@example.com");
        reservationSystem.addUser(2, "Jane Smith", "jane@example.com");

        // Create reservations
        reservationSystem.createReservation(1, 1, LocalDateTime.of(2023, 1, 1, 10, 0), LocalDateTime.of(2023, 1, 1, 11, 0));
        reservationSystem.createReservation(2, 2, LocalDateTime.of(2023, 1, 1, 11, 0), LocalDateTime.of(2023, 1, 1, 12, 0));

        // Display available time slots
        List<LocalDateTime> availableSlots = reservationSystem.getAvailableSlots();
        System.out.println("Available Time Slots:");
        for (LocalDateTime slot : availableSlots) {
            System.out.println(slot);
        }

        // Cancel a reservation
        reservationSystem.cancelReservation(1);

        // Display updated available time slots
        availableSlots = reservationSystem.getAvailableSlots();
        System.out.println("Updated Available Time Slots:");
        for (LocalDateTime slot : availableSlots) {
            System.out.println(slot);
        }
    }
}
