package LinkedList_Chanllenge;

import java.util.*;

public class Itinerary {

    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();

        addPlace(placesToVisit, new Place("Sydney", 0));
        addPlace(placesToVisit, new Place("Adelaide", 1374));
        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Darwin", 3972));
        addPlace(placesToVisit, new Place("Melbourne", 877));
        addPlace(placesToVisit, new Place("Perth", 3923));

        System.out.println("Itinerary loaded with " + placesToVisit.size() + " destinations.");
        printMenu();
        visit(placesToVisit);
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        ListIterator<Place> iterator = list.listIterator();

        while (iterator.hasNext()) {
            Place current = iterator.next();

            if (current.getName().equalsIgnoreCase(place.getName())) {
                System.out.println(place.getName() + " already exists in the itinerary.");
                return;
            }

            if (place.getDistance() < current.getDistance()) {
                iterator.previous();
                iterator.add(place);
                return;
            }
        }

        iterator.add(place);
    }

    private static void printMenu() {
        System.out.println("""
                \nAvailable actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }

    private static void visit(LinkedList<Place> places) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Place> iterator = places.listIterator();
        boolean quit = false;
        boolean forward = true;

        if (places.isEmpty()) {
            System.out.println("No places in the itinerary.");
            return;
        } else {
            System.out.println("Now visiting " + iterator.next());
        }

        while (!quit) {
            System.out.print("Enter action: ");
            String action = scanner.nextLine().trim().toUpperCase();

            switch (action) {
                case "F":
                case "FORWARD":
                    if (!forward) {
                        if (iterator.hasNext()) iterator.next();
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now visiting " + iterator.next());
                    } else {
                        System.out.println("Reached the end of the itinerary.");
                        forward = false;
                    }
                    break;

                case "B":
                case "BACKWARD":
                    if (forward) {
                        if (iterator.hasPrevious()) iterator.previous();
                        forward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting " + iterator.previous());
                    } else {
                        System.out.println("We are at the start of the itinerary.");
                        forward = true;
                    }
                    break;

                case "L":
                case "LIST":
                    printList(places);
                    break;

                case "M":
                case "MENU":
                    printMenu();
                    break;

                case "Q":
                case "QUIT":
                    quit = true;
                    System.out.println("Exiting itinerary navigation...");
                    break;

                default:
                    System.out.println("Invalid action. Please try again.");
                    printMenu();
                    break;
            }
        }
    }

    private static void printList(LinkedList<Place> list) {
        System.out.println("\nPlaces to visit:");
        for (Place place : list) {
            System.out.println(" - " + place);
        }
    }
}
