package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * TransactionDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-27T23:35:56.204603+02:00[Europe/Oslo]", comments = "Generator version: 7.14.0")
public class TransactionDTO {

  private @Nullable String id;

  private Double amount;

  private BigDecimal status;

  public TransactionDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TransactionDTO(Double amount, BigDecimal status) {
    this.amount = amount;
    this.status = status;
  }

  public TransactionDTO id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the transaction
   * @return id
   */
  
  @Schema(name = "id", description = "Unique identifier of the transaction", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  public void setId(@Nullable String id) {
    this.id = id;
  }

  public TransactionDTO amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Amount involved in the transaction
   * @return amount
   */
  @NotNull 
  @Schema(name = "amount", description = "Amount involved in the transaction", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public TransactionDTO status(BigDecimal status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the transaction
   * @return status
   */
  @NotNull @Valid 
  @Schema(name = "status", description = "Status of the transaction", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public BigDecimal getStatus() {
    return status;
  }

  public void setStatus(BigDecimal status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionDTO transactionDTO = (TransactionDTO) o;
    return Objects.equals(this.id, transactionDTO.id) &&
        Objects.equals(this.amount, transactionDTO.amount) &&
        Objects.equals(this.status, transactionDTO.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, amount, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

