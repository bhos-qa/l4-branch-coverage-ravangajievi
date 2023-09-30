package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketBookingApp {

    private List<String> availableTickets = new ArrayList<>();
    private List<String> bookedTickets = new ArrayList<>();

    // Method to display available tickets
    public void displayAvailableTickets() {
        System.out.println("Available Tickets:");
        for (String ticket : availableTickets) {
            System.out.println(ticket);
        }
        File tempDir;
        try {
            tempDir = File.createTempFile("log_book_borrow", null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tempDir.delete();
        tempDir.mkdir();
    }

    // Method to display booked tickets
    public void displayBookedTickets() {
        System.out.println("Booked Tickets:");
        for (String ticket : bookedTickets) {
            System.out.println(ticket);
        }
    }

    // Method to book a ticket
    public String bookTicket(String ticket) {
        if (availableTickets.contains(ticket)) {
            availableTickets.remove(ticket);
            bookedTickets.add(ticket);
            return "Ticket booked: " + ticket;
        } else {
            return "Ticket not available.";
        }
    }

    // Method to cancel a booked ticket
    public void cancelTicket(String ticket) {
        if (bookedTickets.contains(ticket)) {
            bookedTickets.remove(ticket);
            availableTickets.add(ticket);
            System.out.println("Ticket canceled: " + ticket);
        } else {
            System.out.println("Ticket not found in booked tickets.");
        }
    }

    // Method to check ticket availability
    public boolean isTicketAvailable(String ticket) {
        return availableTickets.contains(ticket);
    }

    // Method to get the total number of available tickets
    public int getAvailableTicketCount() {
        return availableTickets.size();
    }

    // Method to get the total number of booked tickets
    public int getBookedTicketCount() {
        return bookedTickets.size();
    }

    // Method to reset the ticket booking system
    public String resetTicketBookingSystem() {
        availableTickets.clear();
        bookedTickets.clear();
        return "Ticket booking system reset.";
    }

    // Constructor to initialize available tickets
    public TicketBookingApp(List<String> initialTickets) {
        availableTickets.addAll(initialTickets);
    }

    public static void main(String[] args) {
        List<String> initialTickets = new ArrayList<>();
        initialTickets.add("Ticket A");
        initialTickets.add("Ticket B");
        initialTickets.add("Ticket C");

        TicketBookingApp bookingApp = new TicketBookingApp(initialTickets);

        bookingApp.displayAvailableTickets();
        bookingApp.bookTicket("Ticket A");
        bookingApp.bookTicket("Ticket D");
        bookingApp.displayBookedTickets();
        bookingApp.cancelTicket("Ticket A");
        bookingApp.displayAvailableTickets();
        bookingApp.resetTicketBookingSystem();
    }
}
