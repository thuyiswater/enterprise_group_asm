package com.howtodoinjava.demo.model;

import javax.persistence.*;

@Entity
@Table(name="TBL_BOOKINGS")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BookingEntity() {

    }

    @Column(name="booking_date")
    private String bookingDate;

    @ManyToOne
    private UserEntity User;
    @Column(name="booking_pick_up_location")
    private String bookingPickUpLocation;

    @Column(name="booking_drop_off_location")
    private String bookingDropOffLocation;

    @Column(name="booking_pick_up_time")
    private String bookingPickUpTime;

    @Column(name="booking_drop_off_time")
    private String bookingDropOffTime;

    @Column(name="booking_number_of_passengers")
    private String bookingNumberOfPassengers;

    @ManyToOne
    private VehicleEntity Vehicle;

    @ManyToOne
    private DriverEntity Driver;

    @OneToOne
    private PaymentEntity Payment;

    @Column(name="booking_status")
    private String bookingStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public UserEntity getUser() {
        return User;
    }

    public void setUser(UserEntity User) {
        this.User = User;
    }

    public String getBookingPickUpLocation() {
        return bookingPickUpLocation;
    }

    public void setBookingPickUpLocation(String bookingPickUpLocation) {
        this.bookingPickUpLocation = bookingPickUpLocation;
    }

    public String getBookingDropOffLocation() {
        return bookingDropOffLocation;
    }

    public void setBookingDropOffLocation(String bookingDropOffLocation) {
        this.bookingDropOffLocation = bookingDropOffLocation;
    }

    public String getBookingPickUpTime() {
        return bookingPickUpTime;
    }

    public void setBookingPickUpTime(String bookingPickUpTime) {
        this.bookingPickUpTime = bookingPickUpTime;
    }

    public String getBookingDropOffTime() {
        return bookingDropOffTime;
    }

    public void setBookingDropOffTime(String bookingDropOffTime) {
        this.bookingDropOffTime = bookingDropOffTime;
    }

    public String getBookingNumberOfPassengers() {
        return bookingNumberOfPassengers;
    }

    public void setBookingNumberOfPassengers(String bookingNumberOfPassengers) {
        this.bookingNumberOfPassengers = bookingNumberOfPassengers;
    }

    public VehicleEntity getVehicle() {
        return Vehicle;
    }

    public void setVehicle(VehicleEntity Vehicle) {
        this.Vehicle = Vehicle;
    }

    public DriverEntity getDriver() {
        return Driver;
    }

    public void setDriver(DriverEntity Driver) {
        this.Driver = Driver;
    }

    public PaymentEntity getPayment() {
        return Payment;
    }

    public void setPayment(PaymentEntity Payment) {
        this.Payment = Payment;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
