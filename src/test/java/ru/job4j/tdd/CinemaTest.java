package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CinemaTest {

    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void buyNoValidDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 02, 30, 12, 05);
        Ticket ticket = cinema.buy(account, 1, 1, date);
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void buyOccup() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 02, 12, 12, 05);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Ticket ticketTwo = cinema.buy(account, 1, 1, date);
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void buyNoValidPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 02, 30, 12, 05);
        Ticket ticket = cinema.buy(account, 5, 13, date);
    }

    @Ignore
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Ignore
    @Test
    public void add() {
        Session session = new Session3D();
        List<Session> sessions = new ArrayList<>();
        sessions.add(session);
        assertThat(session, is(sessions.get(0)));
    }
}