/**
 * OrderType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bjtu.booking.osb;

public class OrderType  implements java.io.Serializable {
    private long orderID;

    private java.util.Date orderDate;

    private java.lang.String orderTotal;

    private com.bjtu.booking.osb.CustomerType customer;

    private java.lang.String orderStatus;

    public OrderType() {
    }

    public OrderType(
           long orderID,
           java.util.Date orderDate,
           java.lang.String orderTotal,
           com.bjtu.booking.osb.CustomerType customer,
           java.lang.String orderStatus) {
           this.orderID = orderID;
           this.orderDate = orderDate;
           this.orderTotal = orderTotal;
           this.customer = customer;
           this.orderStatus = orderStatus;
    }


    /**
     * Gets the orderID value for this OrderType.
     * 
     * @return orderID
     */
    public long getOrderID() {
        return orderID;
    }


    /**
     * Sets the orderID value for this OrderType.
     * 
     * @param orderID
     */
    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }


    /**
     * Gets the orderDate value for this OrderType.
     * 
     * @return orderDate
     */
    public java.util.Date getOrderDate() {
        return orderDate;
    }


    /**
     * Sets the orderDate value for this OrderType.
     * 
     * @param orderDate
     */
    public void setOrderDate(java.util.Date orderDate) {
        this.orderDate = orderDate;
    }


    /**
     * Gets the orderTotal value for this OrderType.
     * 
     * @return orderTotal
     */
    public java.lang.String getOrderTotal() {
        return orderTotal;
    }


    /**
     * Sets the orderTotal value for this OrderType.
     * 
     * @param orderTotal
     */
    public void setOrderTotal(java.lang.String orderTotal) {
        this.orderTotal = orderTotal;
    }


    /**
     * Gets the customer value for this OrderType.
     * 
     * @return customer
     */
    public com.bjtu.booking.osb.CustomerType getCustomer() {
        return customer;
    }


    /**
     * Sets the customer value for this OrderType.
     * 
     * @param customer
     */
    public void setCustomer(com.bjtu.booking.osb.CustomerType customer) {
        this.customer = customer;
    }


    /**
     * Gets the orderStatus value for this OrderType.
     * 
     * @return orderStatus
     */
    public java.lang.String getOrderStatus() {
        return orderStatus;
    }


    /**
     * Sets the orderStatus value for this OrderType.
     * 
     * @param orderStatus
     */
    public void setOrderStatus(java.lang.String orderStatus) {
        this.orderStatus = orderStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OrderType)) return false;
        OrderType other = (OrderType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.orderID == other.getOrderID() &&
            ((this.orderDate==null && other.getOrderDate()==null) || 
             (this.orderDate!=null &&
              this.orderDate.equals(other.getOrderDate()))) &&
            ((this.orderTotal==null && other.getOrderTotal()==null) || 
             (this.orderTotal!=null &&
              this.orderTotal.equals(other.getOrderTotal()))) &&
            ((this.customer==null && other.getCustomer()==null) || 
             (this.customer!=null &&
              this.customer.equals(other.getCustomer()))) &&
            ((this.orderStatus==null && other.getOrderStatus()==null) || 
             (this.orderStatus!=null &&
              this.orderStatus.equals(other.getOrderStatus())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += new Long(getOrderID()).hashCode();
        if (getOrderDate() != null) {
            _hashCode += getOrderDate().hashCode();
        }
        if (getOrderTotal() != null) {
            _hashCode += getOrderTotal().hashCode();
        }
        if (getCustomer() != null) {
            _hashCode += getCustomer().hashCode();
        }
        if (getOrderStatus() != null) {
            _hashCode += getOrderStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OrderType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.example.org/order", "OrderType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.example.org/order", "OrderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.example.org/order", "OrderDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.example.org/order", "OrderTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.example.org/order", "Customer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.example.org/order", "CustomerType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.example.org/order", "OrderStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
