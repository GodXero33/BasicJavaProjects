# Fashion Shop T-Shirt Order Management System

### Coursework 07 - iCET

#### Case Study Overview

The **Fashion Shop**, a recently launched online T-shirt store, handles a large volume of transactions every day. To streamline operations and manage online T-shirt orders efficiently, the shop owner requires a custom system.

As a talented student from the **Institute of Computer Engineering Technology (iCET)**, I have been given the opportunity to develop this system as part of my coursework.

## Requirements

This project involves creating a **Java** application to manage an online T-shirt store. The application includes the following use cases:

1. **Place Order**  
   The system captures the following details for an order:
   - Order ID (generated automatically, starting with "ODR#")
   - Customer Contact Number (validated to start with "0" and be 10 digits long)
   - T-Shirt Size (available sizes: XS, S, M, L, XL, XXL)
   - Quantity (must be greater than 0)
   - Amount (calculated based on the size and quantity)
   - Order Status (initially set to "PROCESSING")

   The user can place multiple orders and will be asked for confirmation before saving the order details.

2. **Search Customer**  
   Allows the user to search for a customer by contact number. Orders placed by the customer will be displayed, sorted by the amount.

3. **Search Order**  
   Allows the user to search for an order by Order ID. If the Order ID is valid, the order details will be shown.

4. **View Reports**  
   Provides various report options, including:
   - Best Customers by total amount
   - Best Selling T-shirt sizes by quantity or total amount
   - View all orders sorted by Order ID or Amount

5. **Change Order Status**  
   Enables changing the status of an order. No changes are allowed if the order is already "DELIVERED".

6. **Delete Order**  
   Allows deleting an order after confirming the details with the user.

---

### System Guidelines
- **No classes** other than the one holding the `main` method can be created.
- All validations mentioned must be implemented.
- Use **Scanner** class for input and **arrays** for storing data.
- Console manipulation and clearing commands are provided to enhance the user interface.
