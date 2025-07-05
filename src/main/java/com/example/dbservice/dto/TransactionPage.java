package com.example.dbservice.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.lang.Nullable;

import java.time.OffsetDateTime;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;


/**
 * TransactionPage
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-27T23:35:56.204603+02:00[Europe/Oslo]", comments = "Generator version: 7.14.0")
public class TransactionPage {

  private @Nullable Integer total;

  private @Nullable Integer offset;

  private @Nullable Integer limit;

  private @Nullable Integer count;

  @Valid
  private List<@Valid TransactionDTO> items = new ArrayList<>();

  public TransactionPage total(@Nullable Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
   */
  
  @Schema(name = "total", example = "100", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total")
  public @Nullable Integer getTotal() {
    return total;
  }

  public void setTotal(@Nullable Integer total) {
    this.total = total;
  }

  public TransactionPage offset(@Nullable Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Get offset
   * @return offset
   */
  
  @Schema(name = "offset", example = "0", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
  
  @Schema(name = "limit", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("limit")
  public @Nullable Integer getLimit() {
    return limit;
  }

  public void setLimit(@Nullable Integer limit) {
    this.limit = limit;
  }

  public TransactionPage count(@Nullable Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
   */
  
  @Schema(name = "count", example = "10", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("count")
  public @Nullable Integer getCount() {
    return count;
  }

  public void setCount(@Nullable Integer count) {
    this.count = count;
  }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionPage transactionPage = (TransactionPage) o;
    return Objects.equals(this.total, transactionPage.total) &&
        Objects.equals(this.offset, transactionPage.offset) &&
        Objects.equals(this.limit, transactionPage.limit) &&
        Objects.equals(this.count, transactionPage.count) &&
        Objects.equals(this.items, transactionPage.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, offset, limit, count, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionPage {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

