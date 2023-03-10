package Itr1;
import java.util.Scanner;

public class BSR {
	static int roomNumbers = 10; // The number of rooms that are available in the library
	static boolean[] rooms = new boolean[roomNumbers]; // Keeping track of the rooms

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Choose one of the options below to be executed: ");
			System.out.println("1. Booking a room");
			System.out.println("2. Checking the availability of the rooms");
			System.out.println("3. Exit the process");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				bookingRoom();
				break;
			case 2:
				availability();
				break;
			case 3:
				System.out.println("Thank you for choosing our services.");
				System.exit(0);
			default:
				System.out.println("Please choose a number from 1 to 3 as shown in our options.");
			}
		}
	}

	private static void bookingRoom() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the room number to be reserved: (There are " + roomNumbers + " rooms available)");
		int roomNumber = sc.nextInt();
		if (roomNumber >= 1 && roomNumber <= roomNumbers) {
			if (!rooms[roomNumber - 1]) {
				rooms[roomNumber - 1] = true;
				System.out.println("Room " + roomNumber + " has been reserved successfully");
			} else {
				System.out.println("Room " + roomNumber + " is already reserved");
			}
		} else {
			System.out.println("Invalid room number, try again");
		}
	}

	private static void availability() {
		System.out.println("Rooms availability status are shown below:");
		for (int i = 0; i < roomNumbers; i++) {
			System.out.println("Room " + (i + 1) + ": " + (rooms[i] ? "Booked" : "Available"));
		}
	}
}
