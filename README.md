Transaction Service - Spring Boot Microservice with OpenAPI

This microservice handles transaction data using Spring Boot, OpenAPI, and Spring Data JPA. It supports basic CRUD operations with DTO-to-Entity mapping and pagination support.

🧰 Technologies Used

Java 17

Spring Boot 3

Spring Data JPA

H2/MySQL Database

OpenAPI Generator (Swagger Codegen)

Maven

RESTful Web Services

Jackson (JSON)

📦 Project Structure

src/main/
├── java/com/example/dbservice
│   ├── api                      # OpenAPI generated interface
│   ├── controller               # Controller implementing interface
│   ├── dto                      # Data Transfer Objects
│   ├── entity                   # JPA Entity class
│   ├── mapper                   # Manual mapper from DTO ↔ Entity
│   ├── repository               # Spring Data JPA repository
│   ├── service                  # Business logic
│   └── TransactionServiceApplication.java  # Main Spring Boot entry
└── resources
    └── application.properties

⚙️ How to Generate OpenAPI Specs (Server Stub)

We use the OpenAPI Generator CLI to generate Spring Boot stubs based on a YAML file.

🔧 Steps

Install OpenAPI Generator CLI:

brew install openapi-generator

Generate Spring Boot server stubs:

openapi-generator generate \
  -i openapi/transaction-api.yaml \
  -g spring \
  -o generated-code \
  --additional-properties=interfaceOnly=true,apiPackage=com.example.dbservice.api,modelPackage=com.example.dbservice.dto

📌 Notes:

-i = Input OpenAPI YAML

-g spring = Spring generator

interfaceOnly=true = only generate interfaces

apiPackage = where interface goes

modelPackage = where DTOs go

You can now implement the generated interface in your controller.

🧩 Controller Layer: TransactionsApiController

@RestController
public class TransactionsApiController implements TransactionsApi {
  private final TransactionService transactionService;

  @Autowired
  public TransactionsApiController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @Override
  public ResponseEntity<TransactionDTO> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.saveTransaction(transactionDTO));
  }

  @Override
  public ResponseEntity<TransactionPage> getTransactionsByStatus(...) {
    return ResponseEntity.ok(transactionService.getTransactionsByStatus(...));
  }
}

💡 Key Concepts:

@RestController: Marks this as a REST controller.

implements TransactionsApi: Automatically wires up the routes from the OpenAPI-generated interface.

@Autowired: Constructor-based dependency injection.

@Valid @RequestBody: Validates JSON payload.

💼 Service Layer: TransactionService

@Service
public class TransactionService {
  @Autowired
  private TransactionRepository transactionRepository;

  public TransactionDTO saveTransaction(TransactionDTO dto) {
    Transaction transaction = TransactionMapper.toEntity(dto);
    Transaction saved = transactionRepository.save(transaction);
    return TransactionMapper.toDto(saved);
  }

  public TransactionPage getTransactionsByStatus(...) {
    List<Transaction> transactions = transactionRepository.findByStatus(...);
    List<TransactionDTO> dtos = transactions.stream().map(TransactionMapper::toDto).toList();
    return new TransactionPage().items(dtos)...;
  }
}

🧠 Concepts:

@Service: Marks business logic component.

Uses mapper to convert between Transaction entity and TransactionDTO.

Calls JPA repository.

🧾 DTOs: TransactionDTO & TransactionPage

TransactionDTO

public class TransactionDTO {
  @Nullable
  private String id;

  @NotNull
  private Double amount;

  @NotNull
  private BigDecimal status;

  // Getters, Setters, Constructors
}

Used to represent a transaction in API communication. Annotated with validation rules.

TransactionPage

public class TransactionPage {
  private Integer total;
  private Integer offset;
  private Integer limit;
  private Integer count;
  private List<TransactionDTO> items;

  // Fluent setters and utility methods
}

Used for paginated responses.

🧮 Entity: Transaction

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

  // Getters and Setters
}

🔁 Mapper: TransactionMapper

public class TransactionMapper {
  public static TransactionDTO toDto(Transaction entity) { ... }
  public static Transaction toEntity(TransactionDTO dto) { ... }
}

Converts between Entity and DTO.

🗄️ Repository: TransactionRepository

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  List<Transaction> findByStatus(BigDecimal status);
}

Spring Data JPA repository with a derived query method.

🚀 Main App: TransactionServiceApplication.java

@SpringBootApplication(scanBasePackages = {"com.example.dbservice", "com.example.dbservice.api"})
@EnableJpaRepositories(basePackages = "com.example.dbservice.repository")
@EntityScan(basePackages = "com.example.dbservice.entity")
public class TransactionServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(TransactionServiceApplication.class, args);
  }
}

Sets up component scanning, JPA support, and runs the Spring Boot application.

🔍 Swagger UI Access

Once you run the service, Swagger UI is available at:

http://localhost:8080/swagger-ui/index.html

🧪 Sample JSON

POST /transactions

{
  "id": "txn-123",
  "amount": 250.75,
  "status": 1
}

Response

{
  "id": "txn-123",
  "amount": 250.75,
  "status": 1
}

GET /transactions/statuses/1

{
  "total": 100,
  "offset": 0,
  "limit": 10,
  "count": 10,
  "items": [
    {
      "id": "txn-001",
      "amount": 100.0,
      "status": 1
    },
    ...
  ]
}

📚 Summary

Layer

Description

Controller

Handles HTTP endpoints via OpenAPI interface

Service

Contains business logic

DTO

Used for API request/response

Entity

Represents DB table

Mapper

Converts DTO ↔ Entity

Repository

JPA-based DB access layer

OpenAPI

Used to generate contract and interface
