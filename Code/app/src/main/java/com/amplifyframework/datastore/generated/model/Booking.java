package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Booking type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Bookings")
public final class Booking implements Model {
  public static final QueryField ID = field("id");
  public static final QueryField PASSENGER_ID = field("passengerID");
  public static final QueryField ROUTE_ID = field("routeID");
  public static final QueryField QUANTITY = field("quantity");
  public static final QueryField DATE_TIME = field("dateTime");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Int", isRequired = true) Integer passengerID;
  private final @ModelField(targetType="Int", isRequired = true) Integer routeID;
  private final @ModelField(targetType="Int", isRequired = true) Integer quantity;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime dateTime;
  public String getId() {
      return id;
  }
  
  public Integer getPassengerId() {
      return passengerID;
  }
  
  public Integer getRouteId() {
      return routeID;
  }
  
  public Integer getQuantity() {
      return quantity;
  }
  
  public Temporal.DateTime getDateTime() {
      return dateTime;
  }
  
  private Booking(String id, Integer passengerID, Integer routeID, Integer quantity, Temporal.DateTime dateTime) {
    this.id = id;
    this.passengerID = passengerID;
    this.routeID = routeID;
    this.quantity = quantity;
    this.dateTime = dateTime;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Booking booking = (Booking) obj;
      return ObjectsCompat.equals(getId(), booking.getId()) &&
              ObjectsCompat.equals(getPassengerId(), booking.getPassengerId()) &&
              ObjectsCompat.equals(getRouteId(), booking.getRouteId()) &&
              ObjectsCompat.equals(getQuantity(), booking.getQuantity()) &&
              ObjectsCompat.equals(getDateTime(), booking.getDateTime());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPassengerId())
      .append(getRouteId())
      .append(getQuantity())
      .append(getDateTime())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Booking {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("passengerID=" + String.valueOf(getPassengerId()) + ", ")
      .append("routeID=" + String.valueOf(getRouteId()) + ", ")
      .append("quantity=" + String.valueOf(getQuantity()) + ", ")
      .append("dateTime=" + String.valueOf(getDateTime()))
      .append("}")
      .toString();
  }
  
  public static PassengerIdStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Booking justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Booking(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      passengerID,
      routeID,
      quantity,
      dateTime);
  }
  public interface PassengerIdStep {
    RouteIdStep passengerId(Integer passengerId);
  }
  

  public interface RouteIdStep {
    QuantityStep routeId(Integer routeId);
  }
  

  public interface QuantityStep {
    DateTimeStep quantity(Integer quantity);
  }
  

  public interface DateTimeStep {
    BuildStep dateTime(Temporal.DateTime dateTime);
  }
  

  public interface BuildStep {
    Booking build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements PassengerIdStep, RouteIdStep, QuantityStep, DateTimeStep, BuildStep {
    private String id;
    private Integer passengerID;
    private Integer routeID;
    private Integer quantity;
    private Temporal.DateTime dateTime;
    @Override
     public Booking build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Booking(
          id,
          passengerID,
          routeID,
          quantity,
          dateTime);
    }
    
    @Override
     public RouteIdStep passengerId(Integer passengerId) {
        Objects.requireNonNull(passengerId);
        this.passengerID = passengerId;
        return this;
    }
    
    @Override
     public QuantityStep routeId(Integer routeId) {
        Objects.requireNonNull(routeId);
        this.routeID = routeId;
        return this;
    }
    
    @Override
     public DateTimeStep quantity(Integer quantity) {
        Objects.requireNonNull(quantity);
        this.quantity = quantity;
        return this;
    }
    
    @Override
     public BuildStep dateTime(Temporal.DateTime dateTime) {
        Objects.requireNonNull(dateTime);
        this.dateTime = dateTime;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Integer passengerId, Integer routeId, Integer quantity, Temporal.DateTime dateTime) {
      super.id(id);
      super.passengerId(passengerId)
        .routeId(routeId)
        .quantity(quantity)
        .dateTime(dateTime);
    }
    
    @Override
     public CopyOfBuilder passengerId(Integer passengerId) {
      return (CopyOfBuilder) super.passengerId(passengerId);
    }
    
    @Override
     public CopyOfBuilder routeId(Integer routeId) {
      return (CopyOfBuilder) super.routeId(routeId);
    }
    
    @Override
     public CopyOfBuilder quantity(Integer quantity) {
      return (CopyOfBuilder) super.quantity(quantity);
    }
    
    @Override
     public CopyOfBuilder dateTime(Temporal.DateTime dateTime) {
      return (CopyOfBuilder) super.dateTime(dateTime);
    }
  }
  
}
