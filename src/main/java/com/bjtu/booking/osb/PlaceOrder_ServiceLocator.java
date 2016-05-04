/**
 * PlaceOrder_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bjtu.booking.osb;

public class PlaceOrder_ServiceLocator extends org.apache.axis.client.Service implements com.bjtu.booking.osb.PlaceOrder_Service {

    public PlaceOrder_ServiceLocator() {
    }


    public PlaceOrder_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PlaceOrder_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PlaceOrderSOAP
    private java.lang.String PlaceOrderSOAP_address = "http://KETIAN-CN2.cn.oracle.com:7001/Order-Messaging-Service/proxy/PlaceOrder";

    public java.lang.String getPlaceOrderSOAPAddress() {
        return PlaceOrderSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PlaceOrderSOAPWSDDServiceName = "PlaceOrderSOAP";

    public java.lang.String getPlaceOrderSOAPWSDDServiceName() {
        return PlaceOrderSOAPWSDDServiceName;
    }

    public void setPlaceOrderSOAPWSDDServiceName(java.lang.String name) {
        PlaceOrderSOAPWSDDServiceName = name;
    }

    public com.bjtu.booking.osb.PlaceOrder_PortType getPlaceOrderSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PlaceOrderSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPlaceOrderSOAP(endpoint);
    }

    public com.bjtu.booking.osb.PlaceOrder_PortType getPlaceOrderSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.bjtu.booking.osb.PlaceOrderSOAPStub _stub = new com.bjtu.booking.osb.PlaceOrderSOAPStub(portAddress, this);
            _stub.setPortName(getPlaceOrderSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPlaceOrderSOAPEndpointAddress(java.lang.String address) {
        PlaceOrderSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.bjtu.booking.osb.PlaceOrder_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.bjtu.booking.osb.PlaceOrderSOAPStub _stub = new com.bjtu.booking.osb.PlaceOrderSOAPStub(new java.net.URL(PlaceOrderSOAP_address), this);
                _stub.setPortName(getPlaceOrderSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PlaceOrderSOAP".equals(inputPortName)) {
            return getPlaceOrderSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.example.org/order", "PlaceOrder");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.example.org/order", "PlaceOrderSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PlaceOrderSOAP".equals(portName)) {
            setPlaceOrderSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
