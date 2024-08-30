import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Room class to represent a room in the hotel
class Room {
    private int roomNumber;
    private String category;
    private boolean available;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// Reservation class to represent a reservation
class Reservation {
    private int roomNumber;
    private String customerName;

    public Reservation(int roomNumber, String customerName) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
}

// Hotel class to manage rooms and reservations
class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(201, "Single"));
        rooms.add(new Room(202, "Double"));
        rooms.add(new Room(203, "Suite"));
    }

    public void searchAvailableRooms(String category) {
        System.out.println("Available " + category + " rooms:");
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                System.out.println("Room Number: " + room.getRoomNumber());
            }
        }
    }

    public boolean makeReservation(int roomNumber, String customerName) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false);
                reservations.add(new Reservation(roomNumber, customerName));
                System.out.println("Reservation successful for room number " + roomNumber);
                return true;
            }
        }
        System.out.println("Room number " + roomNumber + " is not available.");
        return false;
    }

    public void viewReservations() {
        System.out.println("Current Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println("Room Number: " + reservation.getRoomNumber() +
                    ", Customer Name: " + reservation.getCustomerName());
        }
    }
}

public class Main {


    private static Hotel hotel = new Hotel();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void searchAvailableRooms() {
        System.out.print("Enter room category (Single, Double, Suite): ");
        String category = scanner.nextLine();
        hotel.searchAvailableRooms(category);
    }

    private static void makeReservation() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        hotel.makeReservation(roomNumber, customerName);
    }

    private static void viewReservations() {
        hotel.viewReservations();

    }
}