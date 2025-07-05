
# Transaction Service - Spring Boot Microservice with OpenAPI

This project is a Spring Boot microservice designed to manage transactions, demonstrating a clean architecture involving OpenAPI code generation, DTOs, services, controllers, and repositories.

---

## 📦 Project Overview

This service exposes two REST APIs:

- `POST /transactions`: Create a new transaction
- `GET /transactions/statuses/{status}`: Get transactions filtered by status with pagination

---

## 🔧 How OpenAPI Specs Generate the Code

### 📌 What is OpenAPI?
OpenAPI is a standard specification for documenting REST APIs. With an OpenAPI YAML/JSON file, we can automatically generate:

- Java interfaces (controllers)
- DTO classes
- API contracts

### ✅ How to Generate Server Stubs

```bash
openapi-generator-cli generate \
  -i transaction-api.yaml \
  -g spring \
  -o ./generated-code \
  --additional-properties interfaceOnly=true
```

This creates:
- `TransactionsApi.java` (interface)
- `TransactionDTO.java`, `TransactionPage.java` (DTOs)
- Validation, schema metadata via `@Schema`, `@Valid`

---

## 🚀 Controller Layer

### `TransactionsApiController implements TransactionsApi`

- `@RestController`: Declares this class as a REST controller.
- `@Autowired`: Injects the service via constructor.
- `@Override`: Ensures methods match the OpenAPI interface.
- Uses methods:
  - `createTransaction(TransactionDTO dto)`
  - `getTransactionsByStatus(...)`

> The OpenAPI-generated interface defines all method mappings. No need for `@PostMapping`, `@GetMapping` here.

---

## 🧠 How Request JSON is Converted to DTO

Spring Boot uses:
- `@RequestBody` to parse JSON
- `@Valid` to trigger validations like `@NotNull`
- Jackson library to deserialize into `TransactionDTO`

Example:

```json
{
  "id": "txn-123",
  "amount": 200.0,
  "status": 1
}
```

Spring auto-binds this to:

```java
public ResponseEntity<TransactionDTO> createTransaction(@Valid @RequestBody TransactionDTO dto)
```

---

## 💼 Service Layer

### `TransactionService`

Handles business logic.

```java
@Service
public class TransactionService {
    public TransactionDTO saveTransaction(TransactionDTO dto) {
        Transaction entity = TransactionMapper.toEntity(dto);
        Transaction saved = transactionRepository.save(entity);
        return TransactionMapper.toDto(saved);
    }

    public List<TransactionDTO> getTransactionsByStatus(BigDecimal status) {
        return transactionRepository.findByStatus(status)
                                    .stream()
                                    .map(TransactionMapper::toDto)
                                    .collect(Collectors.toList());
    }
}
```

---

## 🔄 Mapper Layer

### `TransactionMapper`

Handles conversion between `Transaction` entity and `TransactionDTO`.

```java
public static Transaction toEntity(TransactionDTO dto)
public static TransactionDTO toDto(Transaction entity)
```

This keeps the DTO clean and separate from the DB structure.

---

## 🧾 Entity Layer

### `Transaction.java`

```java
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigDecimal status;
}
```

Mapped to the `transactions` table.

---

## 🧰 Repository Layer

### `TransactionRepository`

```java
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByStatus(BigDecimal status);
}
```

Spring Data JPA creates the query automatically.

---

## 📜 DTOs

### `TransactionDTO`

```java
public class TransactionDTO {
    @Nullable
    private String id;

    @NotNull
    private Double amount;

    @NotNull
    private BigDecimal status;
}
```

Used for incoming and outgoing transaction data in APIs.

### `TransactionPage`

Used for paginated responses.

```java
public class TransactionPage {
    private Integer total;
    private Integer offset;
    private Integer limit;
    private Integer count;
    private List<TransactionDTO> items;
}
```

---

## 📖 Swagger UI

If you're using Springdoc or Swagger:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.15</version>
</dependency>
```

Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🧪 Sample cURL Requests

```bash
curl -X POST http://localhost:8080/transactions   -H "Content-Type: application/json"   -d '{"id": "txn-123", "amount": 200.0, "status": 1}'

curl -X GET http://localhost:8080/transactions/statuses/1?offset=0&limit=10
```

---

## 🧠 Full Request Flow

1. JSON request hits controller
2. Spring converts JSON to DTO using Jackson
3. Controller calls service
4. Service maps DTO → Entity, saves to DB
5. Entity → DTO mapped back
6. DTO returned as JSON response

---

## ✅ Summary

Component | Responsibility
--------- | --------------
OpenAPI | Defines contract
Controller | Implements interface
Service | Handles business logic
Mapper | Converts DTO ↔ Entity
Entity | DB persistence
Repository | DB access
DTOs | Clean API model

---

Feel free to enhance this README with diagrams or integration examples!
