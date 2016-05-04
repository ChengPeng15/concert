/**
 * CustomerType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bjtu.booking.osb;

public class CustomerType  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String name;

    private java.lang.String email;

    private java.lang.String CCnumber;

    private java.lang.String shippingAddress;

    public CustomerType() {
    }

    public CustomerType(
           java.lang.String name,
           java.lang.String email,
           java.lang.String CCnumber,
           java.lang.String shippingAddress) {
           this.name = name;
           this.email = email;
           this.CCnumber = CCnumber;
           this.shippingAddress = shippingAddress;
    }


    /**
     * Gets the name value for this CustomerType.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this CustomerType.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the email value for this CustomerType.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this CustomerType.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the CCnumber value for this CustomerType.
     * 
     * @return CCnumber
     */
    public java.lang.String getCCnumber() {
        return CCnumber;
    }


    /**
     * Sets the CCnumber value for this CustomerType.
     * 
     * @param CCnumber
     */
    public void setCCnumber(java.lang.String CCnumber) {
        this.CCnumber = CCnumber;
    }


    /**
     * Gets the shippingAddress value for this CustomerType.
     * 
     * @return shippingAddress
     */
    public java.lang.String getShippingAddress() {
        return shippingAddress;
    }


    /**
     * Sets the shippingAddress value for this CustomerType.
     * 
     * @param shippingAddress
     */
    public void setShippingAddress(java.lang.String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerType)) return false;
        CustomerType other = (CustomerType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.CCnumber==null && other.getCCnumber()==null) || 
             (this.CCnumber!=null &&
              this.CCnumber.equals(other.getCCnumber()))) &&
            ((this.shippingAddress==null && other.getShippingAddress()==null) || 
             (this.shippingAddress!=null &&
              this.shippingAddress.equals(other.getShippingAddress())));
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
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getCCnumber() != null) {
            _hashCode += getCCnumber().hashCode();
        }
        if (getShippingAddress() != null) {
            _hashCode += getShippingAddress().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.example.org/order", "CustomerType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.example.org/order", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.example.org/order", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCnumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.example.org/order", "CCnumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shippingAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.example.org/order", "ShippingAddress"));
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
