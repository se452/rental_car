/**
 * Represents a car entity within the Car Rental System.
 *
 * <p>This class encapsulates the details of a car, including its make, model, year, availability, and other relevant attributes.
 * It serves as the data model for the system, and objects of this class are persisted in the database.
 *
 * <p>Key attributes of the Car class include:
 * <ul>
 *     <li>id - Unique identifier for each car.</li>
 *     <li>make - The manufacturer of the car.</li>
 *     <li>model - The specific model of the car.</li>
 *     <li>year - The production year of the car.</li>
 *     <li>availability - Boolean flag to indicate if the car is available for rental.</li>
 * </ul>
 * <p>This class is used in both admin and customer-facing parts of the application to display and manage car details.
 * Ensure that this class is properly mapped to the corresponding database table in the ORM configuration.
 * 
 * Provides database interaction methods for the Car entity in the Car Rental System.
 *
 * <p>This interface extends JpaRepository to leverage common database operations such as saving, updating, deleting, 
 * and finding cars. It also provides support for custom queries if needed.
 *
 * <p>This repository serves as a data access layer, abstracting the complexities of database interaction from the service layer.
 * Make sure to define custom query methods based on business requirements.
 * 
 * 
 * Data Transfer Object (DTO) for the Car entity within the Car Rental System.
 *
 * <p>This class is used to encapsulate the data related to a car when transferring between different layers of the application,
 * such as between the service layer and the controller layer. It helps in decoupling the internal representation of the Car entity
 * from its exposed API representation.
 *
 * <p>Key fields of the CarDto include:
 * <ul>
 *     <li>id - The unique identifier of the car.</li>
 *     <li>make - The make of the car (e.g., Toyota, Honda).</li>
 *     <li>model - The model of the car (e.g., Camry, Accord).</li>
 *     <li>year - The year of manufacture.</li>
 *     <li>availability - Indicates if the car is available for rental.</li>
 * </ul>
 * 
 * 
 * Provides RESTful API endpoints for managing cars within the Car Rental System.
 *
 * <p>This controller is responsible for handling requests related to car management, specifically for the admin users of the system.
 * It exposes endpoints for performing CRUD operations (Create, Read, Update, Delete) on car entities.
 *
 * <p>Key functionalities include:
 * <ul>
 *     <li>GET /admin/cars - Retrieves a list of all cars in the system.</li>
 *     <li>POST /admin/cars - Adds a new car to the system.</li>
 *     <li>PUT /admin/cars/{id} - Updates details of an existing car.</li>
 *     <li>DELETE /admin/cars/{id} - Removes a car from the system.</li>
 * </ul>
 *
 * @author Prathamesh
 */
 


package com.carRental.car;

//Prathamesh Deepak Raut
//2124540