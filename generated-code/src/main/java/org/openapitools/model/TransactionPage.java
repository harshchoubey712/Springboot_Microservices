package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.TransactionDTO;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TransactionPage
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-27T12:36:29.253976+02:00[Europe/Oslo]", comments = "Generator version: 7.14.0")
public class TransactionPage {

  @Valid
  private List<@Valid TransactionDTO> items = new ArrayList<>();

  private @Nullable Integer count;

  private @Nullable Integer offset;

  private @Nullable Integer limit;

  private @Nullable Integer total;

  public TransactionPage items(List<@Valid TransactionDTO> items) {
    this.items = items;
    return this;
  }

  public TransactionPage addItemsItem(TransactionDTO itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
   */
  @Valid 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("items")
  public List<@Valid TransactionDTO> getItems() {
    return items;
  }

  public void setItems(List<@Valid TransactionDTO> items) {
    this.items = items;
  }

  public TransactionPage count(@Nullable Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
   */
  
  @Schema(name = "count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("count")
  public @Nullable Integer getCount() {
    return count;
  }

  public void setCount(@Nullable Integer count) {
    this.count = count;
  }

  public TransactionPage offset(@Nullable Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
   */
  
  @Schema(name = "offset", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("offset")
  public @Nullable Integer getOffset() {
    return offset;
  }

  public void setOffset(@Nullable Integer offset) {
    this.offset = offset;
  }

  public TransactionPage limit(@Nullable Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Get limit
   * @return limit
   */
  
  @Schema(name = "limit", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("limit")
  public @Nullable Integer getLimit() {
    return limit;
  }

  public void setLimit(@Nullable Integer limit) {
    this.limit = limit;
  }

  public TransactionPage total(@Nullable Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
   */
  
  @Schema(name = "total", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total")
  public @Nullable Integer getTotal() {
    return total;
  }

  public void setTotal(@Nullable Integer total) {
    this.total = total;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionPage transactionPage = (TransactionPage) o;
    return Objects.equals(this.items, transactionPage.items) &&
        Objects.equals(this.count, transactionPage.count) &&
        Objects.equals(this.offset, transactionPage.offset) &&
        Objects.equals(this.limit, transactionPage.limit) &&
        Objects.equals(this.total, transactionPage.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, count, offset, limit, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionPage {\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

