import java.util.Arrays;
import java.util.Scanner;



/*
innov_max -> "Building the future, one algorithm at a time."
 */
public class AirlineReservationSystem {
    private static final int FIRST_CLASS_CAPACITY = 5;
    private static final int ECONOMY_CAPACITY = 5;

    private static boolean[] seats = new boolean[11];

    static {
        Arrays.fill(seats, false);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueReservation = true;

        while (continueReservation) {
            int seatType = getSeatType(scanner);
            int seatNumber = assignSeat(seatType);

            if (seatNumber != -1) {
                printBoardingPass(seatNumber, seatType);
            } else {
                System.out.println("All seats in the selected section are occupied.");

                if (seatType == 1) {
                    int alternativeSeatType = 2;
                    System.out.print("Would you like to be placed in the Economy section? (y/n): ");
                    String choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("y")) {
                        seatNumber = assignSeat(alternativeSeatType);

                        if (seatNumber != -1) {
                            printBoardingPass(seatNumber, alternativeSeatType);
                        } else {
                            System.out.println("Next flight leaves in 3 hours.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                } else {
                    int alternativeSeatType = 1;
                    System.out.print("Would you like to be placed in the First Class section? (y/n): ");
                    String choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("y")) {
                        seatNumber = assignSeat(alternativeSeatType);

                        if (seatNumber != -1) {
                            printBoardingPass(seatNumber, alternativeSeatType);
                        } else {
                            System.out.println("Next flight leaves in 3 hours.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }
            }

            if (seatNumber != -1) {
                System.out.print("Would you like to make another reservation? (y/n): ");
                String choice = scanner.nextLine();
                continueReservation = choice.equalsIgnoreCase("y");
            }
        }
    }

    private static int getSeatType(Scanner scanner) {
        int seatType;
        do {
            System.out.println("Please select the seat type:");
            System.out.println("1. First Class");
            System.out.println("2. Economy");
            System.out.print("Enter your choice (1 or 2): ");
            seatType = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } while (seatType != 1 && seatType != 2);

        return seatType;
    }

    private static int assignSeat(int seatType) {
        int seatNumber = -1;
        if (seatType == 1) {
            for (int i = 1; i <= FIRST_CLASS_CAPACITY; i++) {
                if (!seats[i]) {
                    seats[i] = true;
                    seatNumber = i;
                    break;
                }
            }
        } else {
            for (int i = FIRST_CLASS_CAPACITY + 1; i <= FIRST_CLASS_CAPACITY + ECONOMY_CAPACITY; i++) {
                if (!seats[i]) {
                    seats[i] = true;
                    seatNumber = i;
                    break;
                }
            }
        }
        return seatNumber;
    }

    private static void printBoardingPass(int seatNumber, int seatType) {
        System.out.println("\nBoarding Pass");
        System.out.println("--------------");
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Seat Type: " + (seatType == 1 ? "First Class" : "Economy"));
        System.out.println("--------------\n");
    }
}

