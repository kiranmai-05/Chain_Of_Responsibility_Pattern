# Chain of Responsibility Design Pattern in Java

## Overview

This project demonstrates the **Chain of Responsibility Design Pattern** in Java using a **Swiggy Order Processing System**.

The Chain of Responsibility is a **Behavioral Design Pattern** in which a request is passed through a chain of handlers. Each handler performs its specific responsibility and then passes the request to the next handler in the chain.

In this project, an order passes through multiple stages such as order validation, payment processing, order preparation, delivery assignment, and order tracking.

## How It Works

The order is processed through the following chain:

## text
Order
  ↓
Order Validation
  ↓
Payment Processing
  ↓
Order Preparation
  ↓
Delivery Assignment
  ↓
Order Tracking
##Main Components
- OrderHandler
    OrderHandler is the abstract base class that contains the reference to the next handler in the chain.
- OrderValidationHandler
    Validates and processes the order before passing it to the next handler.
- PaymentProcessingHandler
    Processes the payment for the order and forwards it to the next handler.
- OrderPreparationHandler
    Handles the preparation of the order.
- DeliveryAssignemtHandler
    Assigns the order to a delivery partner.
- OrderTrackingHandler
    Provides the final order tracking information.
## Advantages
  - Reduces direct coupling between the sender and individual handlers.
  - Each handler has a specific responsibility.
  - Handlers can be easily added, removed, or reordered.
  - Makes request-processing logic easier to organize.
  - Allows a request to pass through multiple processing stages.
