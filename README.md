# Restaurant Delivery System

Welcome to the Restaurant Delivery System! This project aims to provide a comprehensive solution for managing restaurant deliveries, from handling menus to tracking orders. Below, you'll find all the necessary information to understand and utilize this system effectively.

## Overview

The Restaurant Delivery System is designed to cater to the needs of various users involved in the delivery process:

- **Admin**: Responsible for managing restaurants, menus, and delivery personnel.
- **Delivery Man**: Handles delivery tasks, including viewing, accepting, and completing deliveries.
- **Client**: Can create, edit, and close their accounts, place orders, and view order history.
- **Restaurateur**: Manages orders specific to their restaurant, accepting and marking orders as ready.
- **Manager**: Has access restricted to their restaurant, allowing them to edit restaurant details, manage menus, and view orders.

## Features

### Admin
- Create, edit, and delete restaurants.
- Manage menus for each restaurant.
- Add, edit, and disable delivery personnel.

### Delivery Man
- View available deliveries.
- Accept and complete deliveries.

### Client
- Create, edit, and close accounts.
- Place orders from restaurants.
- View order history.

### Restaurateur
- Accept orders for their restaurant.
- Mark orders as ready for delivery.

### Manager
- Edit restaurant details.
- Manage menus.
- View orders for their restaurant.

## Requirements

### Entities
1. **Admin**
   - Restaurant management.
   - Menu management.
   - Delivery personnel management.
2. **Delivery Man**
   - View and handle deliveries.
3. **Client**
   - Account management.
   - Place orders.
4. **Restaurateur**
   - Manage restaurant orders.
5. **Manager**
   - Manage restaurant details and menus.

## Forms

### Restaurant
- Name
- Address
- Phone number
- Opening Time
- Delivery Areas

### Menu
- Item
- Price

### Delivery Man
- Name
- Phone Number
- Delivery Area

### Access Accounts
- Delivery Man: Username, Password
- Manager: Username, Password
- Restaurateur: Username, Password

## Implementation

This project is implemented in Java, utilizing Object-Oriented Programming (OOP) principles and the Model-View-Controller (MVC) architecture. The system ensures user-friendliness, validation, and an appealing interface.