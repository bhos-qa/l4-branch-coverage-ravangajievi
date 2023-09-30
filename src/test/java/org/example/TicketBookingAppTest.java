package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketBookingAppTest {


    @Test
    void bookTicket() {
        List<String> initialTickets = new ArrayList<>();
        initialTickets.add("Ticket A");
        initialTickets.add("Ticket B");
        initialTickets.add("Ticket C");
        TicketBookingApp bookingApp = new TicketBookingApp(initialTickets);
        assertEquals("Ticket booked: Ticket A", bookingApp.bookTicket("Ticket A"));

    }

    @Test
    void isTicketAvailable() {
        List<String> initialTickets = new ArrayList<>();
        initialTickets.add("Ticket A");
        initialTickets.add("Ticket B");
        initialTickets.add("Ticket C");
        TicketBookingApp bookingApp = new TicketBookingApp(initialTickets);
        bookingApp.bookTicket("Ticket A");
        assertTrue(bookingApp.isTicketAvailable("Ticket B"));
    }

    @Test
    void getAvailableTicketCount() {
        List<String> initialTickets = new ArrayList<>();
        initialTickets.add("Ticket A");
        initialTickets.add("Ticket B");
        initialTickets.add("Ticket C");
        TicketBookingApp bookingApp = new TicketBookingApp(initialTickets);
        bookingApp.bookTicket("Ticket A");
        assertEquals(1,bookingApp.getBookedTicketCount());
    }

    @Test
    void getBookedTicketCount() {
        List<String> initialTickets = new ArrayList<>();
        initialTickets.add("Ticket A");
        initialTickets.add("Ticket B");
        initialTickets.add("Ticket C");
        TicketBookingApp bookingApp = new TicketBookingApp(initialTickets);
        bookingApp.bookTicket("Ticket A");
        bookingApp.bookTicket("Ticket B");
        assertEquals(2,bookingApp.getBookedTicketCount());
    }

    @Test
    void resetTicketBookingSystem() {
        List<String> initialTickets = new ArrayList<>();
        initialTickets.add("Ticket A");
        initialTickets.add("Ticket B");
        initialTickets.add("Ticket C");
        TicketBookingApp bookingApp = new TicketBookingApp(initialTickets);
        assertEquals("Ticket booking system reset.",bookingApp.resetTicketBookingSystem());
    }
}