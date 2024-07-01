package com.restaurant.billingsystem.controller;

import com.restaurant.billingsystem.model.Reservation;
import com.restaurant.billingsystem.model.Table;
import com.restaurant.billingsystem.service.TableService;
import com.restaurant.billingsystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reservations")
public class ReservationController{
    @Autowired
    private ReservationService reservationService;

    @Autowired 
    private TableService tableService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }
    
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable int id, @RequestBody Reservation updatedReservation) {
        return reservationService.updateReservation(id, updatedReservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }

    @PostMapping("/{reservationId}/assignTable/{tableId}")
    public void assignReservationToTable(@PathVariable int reservationId, @PathVariable int tableId) {
        Table table = tableService.getTableById(tableId);
        if (table != null) {
            reservationService.assignReservationToTable(reservationId, table);
        }
    }
    
}