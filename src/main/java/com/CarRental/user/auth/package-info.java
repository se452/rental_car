/**
 * This package holds all authentication and authorization functionality for CarRental.
 * @author [Yogeshkumar Ghanshyambhai Lakhani]
 *
 * <h1>Package Overview</h1>
 *
 * <h2>AuthService Interface</h2>
 * <ul>
 *     <li>Defines authentication-related operations such as creating a customer and checking if a customer exists with a given email.</li>
 *     <li>Methods:
 *         <ul>
 *             <li><code>UserDto createCustomer(SignupRequest signupRequest)</code> - Creates a new customer based on the signup request.</li>
 *             <li><code>boolean hasCustomerWithEmail(String email)</code> - Checks if a customer exists with the provided email.</li>
 *         </ul>
 *     </li>
 * </ul>
 *
 * <h2>AuthServiceImpl Class</h2>
 * <ul>
 *     <li>Implementation of the <code>AuthService</code> interface.</li>
 *     <li>Uses <code>UserRepository</code> to interact with User data.</li>
 *     <li>Methods:
 *         <ul>
 *             <li><code>createCustomer</code> - Creates and saves a new User entity from the SignupRequest.</li>
 *             <li><code>hasCustomerWithEmail</code> - Checks if a User exists with the provided email.</li>
 *         </ul>
 *     </li>
 * </ul>
 *
 * <h3>LOMBOK and Spring Usage:</h3>
 *
 * <ul>
 *     <li><code>@Service</code> - Marks the class as a Spring service component.</li>
 *     <li><code>@RequiredArgsConstructor</code> - Generates a constructor with required arguments (final fields).</li>
 * </ul>
 *
 * ///////////////////////////////////
 */
package com.CarRental.user.auth;

