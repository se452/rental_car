/**
 * Provides classes and interfaces for managing car bookings within the Car Rental System.
 *
 * <p>
 * This package encapsulates the functionality required to handle car bookings,
 * including the management of user interactions for booking, updating, and
 * canceling reservations.
 *
 * <p>
 * Key classes in the Booking_Car package include:
 * <ul>
 * <li><strong>Booking_Car</strong> - This class is responsible for booking a
 * car, taking user details, and storing them in the database.</li>
 * <li><strong>BookingHistory</strong> - This class manages the booking history
 * for users, allowing them to view past bookings.</li>
 * <li><strong>AdminBookingManager</strong> - This class provides admin
 * functionalities to manage all bookings, including viewing and canceling
 * bookings for all users.</li>
 * </ul>
 *
 * <p>
 * Functionality provided by the Booking_Car class includes:
 * <ul>
 * <li><strong>bookCar()</strong> - Book a car based on user input.</li>
 * <li><strong>displayCarDetails()</strong> - Show the details of the booked
 * car.</li>
 * <li><strong>displayBookingDetails()</strong> - Provide details of the current
 * booking.</li>
 * <li><strong>displayBookingHistory()</strong> - Retrieve the user's booking
 * history.</li>
 * <li><strong>cancelBooking()</strong> - Allow users to cancel their
 * bookings.</li>
 * <li><strong>updateBooking()</strong> - Update existing bookings.</li>
 * <li><strong>Admin functionalities</strong> - Manage booking details and
 * histories from an admin perspective.</li>
 * </ul>
 *
 * <p>
 * This package serves both customer and admin functionalities, providing
 * essential methods to interact with the booking system while ensuring data
 * integrity and security.
 *
 * @author Manthan Mohile
 */
package com.CarRental.Booking_Car;
