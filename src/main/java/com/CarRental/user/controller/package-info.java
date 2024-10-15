/**
 * This package holds all REST controllers related to user authentication and management for CarRental.
 * @author [Yogeshkumar Ghanshyambhai Lakhani]
 *
 * <h1>Package Overview</h1>
 *
 * <h2>AuthController Class</h2>
 * <ul>
 *     <li>Defines endpoints for user authentication operations.</li>
 *     <li>Endpoint: <code>/api/auth/signup</code>
 *         <ul>
 *             <li>Allows new customers to sign up by providing a <code>SignupRequest</code>.</li>
 *             <li>Checks if a customer already exists with the provided email.</li>
 *             <li>Returns appropriate HTTP responses based on the outcome:
 *                 <ul>
 *                     <li><code>201 Created</code> - Customer created successfully.</li>
 *                     <li><code>406 Not Acceptable</code> - Customer already exists with this email.</li>
 *                     <li><code>400 Bad Request</code> - Customer not created due to bad input.</li>
 *                 </ul>
 *             </li>
 *         </ul>
 *     </li>
 * </ul>
 *
 * <h3>Spring MVC and Lombok Usage:</h3>
 *
 * <ul>
 *     <li><code>@RestController</code> - Indicates that the class is a REST controller.</li>
 *     <li><code>@RequestMapping("/api/auth")</code> - Base path for all endpoints in this controller.</li>
 *     <li><code>@PostMapping("/signup")</code> - Maps HTTP POST requests to the <code>signupCustomer</code> method.</li>
 *     <li><code>@RequiredArgsConstructor</code> - Generates a constructor for final fields.</li>
 *     <li><code>@RequestBody</code> - Indicates that a method parameter should be bound to the body of the HTTP request.</li>
 * </ul>
 *
 * ///////////////////////////////////
 */
package com.CarRental.user.controller;