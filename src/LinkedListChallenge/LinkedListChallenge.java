package LinkedListChallenge;

import java.util.*;

public class LinkedListChallenge {

    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();

        addPlace(places, new Place("Sydney", 0));
        addPlace(places, new Place("Adelaide", 1374));
        addPlace(places, new Place("Alice Springs", 2771));
        addPlace(places, new Place("Brisbane", 917));
        addPlace(places, new Place("Darwin", 3972));
        addPlace(places, new Place("Melbourne", 877));
        addPlace(places, new Place("Perth", 3923));

        visit(places);
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        ListIterator<Place> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Place current = iterator.next();
            if (current.getName().equalsIgnoreCase(place.getName())) return; // no duplicates
            if (place.getDistance() < current.getDistance()) {
                iterator.previous();
                iterator.add(place);
                return;
            }
        }
        iterator.add(place);
    }

    private static void visit(LinkedList<Place> places) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Place> it = places.listIterator();
        if (!it.hasNext()) return;
        System.out.println("Now visiting " + it.next());

        printMenu();

        while (!quit) {
            System.out.print("Action: ");
            String action = sc.nextLine().toUpperCase();

            switch (action) {
                case "F", "FORWARD" -> {
                    if (!forward && it.hasNext()) it.next();
                    forward = true;
                    if (it.hasNext()) System.out.println("Now visiting " + it.next());
                    else System.out.println("Reached end of list");
                }
                case "B", "BACKWARD" -> {
                    if (forward && it.hasPrevious()) it.previous();
                    forward = false;
                    if (it.hasPrevious()) System.out.println("Now visiting " + it.previous());
                    else System.out.println("At start of list");
                }
                case "L", "LIST" -> places.forEach(System.out::println);
                case "M", "MENU" -> printMenu();
                case "Q", "QUIT" -> quit = true;
                default -> System.out.println("Invalid action");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                Available actions:
                (F)orward
                (B)ackward
                (L)ist places
                (M)enu
                (Q)uit
                """);
    }
}
