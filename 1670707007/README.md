# Digital Safe API

This is a Spring Boot application that demonstrates encapsulation through a Digital Safe API. The safe can only deposit money and cannot withdraw money. Owner name is set to "Smine".

## Features

- **Encapsulation**: Private properties (`ownerName`, `balance`) with controlled access
- **Deposit Only**: Can only deposit money, no withdrawal functionality
- **Validation**: Only accepts positive amounts for deposits
- **REST API**: Provides endpoints to interact with the digital safe

## API Endpoints

### 1. Get Owner Name
- **Method**: GET
- **URL**: `http://localhost:8080/safe/owner`
- **Response**: Returns "Owner: Smine"

### 2. Get Current Balance
- **Method**: GET
- **URL**: `http://localhost:8080/safe/balance`
- **Response**: Returns "Current balance: [amount]"

### 3. Deposit Money
- **Method**: POST
- **URL**: `http://localhost:8080/safe/deposit`
- **Parameter**: `amount` (double)
- **Response**: Returns success message with new balance or error message

## How to Run

1. Make sure you have Java 17+ and Maven installed
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. The application will start on `http://localhost:8080`

## Testing the API

### Using curl:

1. **Get owner name**:
   ```bash
   curl http://localhost:8080/safe/owner
   # Response: "Owner: Smine"
   ```

2. **Get balance**:
   ```bash
   curl http://localhost:8080/safe/balance
   # Response: "Current balance: 0.0"
   ```

3. **Deposit money**:
   ```bash
   curl -X POST "http://localhost:8080/safe/deposit?amount=100.0"
   # Response: "Deposited 100.0 successfully. New balance: 100.0"
   ```

4. **Try invalid deposit**:
   ```bash
   curl -X POST "http://localhost:8080/safe/deposit?amount=-50.0"
   # Response: "Error: Deposit amount must be positive"
   ```

### Using a REST client:
- Use Postman, Insomnia, or any REST client to test the endpoints

## Example Usage

1. Start the application
2. Check owner: `GET /safe/owner` → Returns "Owner: Smine"
3. Check initial balance: `GET /safe/balance` → Returns "Current balance: 0.0"
4. Deposit money: `POST /safe/deposit?amount=500.0` → Returns "Deposited 500.0 successfully. New balance: 500.0"
5. Check new balance: `GET /safe/balance` → Returns "Current balance: 500.0"
6. Try invalid deposit: `POST /safe/deposit?amount=-100.0` → Returns "Error: Deposit amount must be positive"

## Encapsulation Demonstration

The `DigitalSafe` class demonstrates encapsulation by:
- Making `ownerName` and `balance` private
- Providing controlled access through public methods
- Preventing direct modification of balance
- No withdrawal functionality (deposit only)

## Running Tests

```bash
mvn test
```

This will run unit tests to verify the DigitalSafe functionality.
