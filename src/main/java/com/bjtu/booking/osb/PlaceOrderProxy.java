package com.bjtu.booking.osb;

public class PlaceOrderProxy implements com.bjtu.booking.osb.PlaceOrder_PortType {
  private String _endpoint = null;
  private com.bjtu.booking.osb.PlaceOrder_PortType placeOrder_PortType = null;
  
  public PlaceOrderProxy() {
    _initPlaceOrderProxy();
  }
  
  public PlaceOrderProxy(String endpoint) {
    _endpoint = endpoint;
    _initPlaceOrderProxy();
  }
  
  private void _initPlaceOrderProxy() {
    try {
      placeOrder_PortType = (new com.bjtu.booking.osb.PlaceOrder_ServiceLocator()).getPlaceOrderSOAP();
      if (placeOrder_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)placeOrder_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)placeOrder_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (placeOrder_PortType != null)
      ((javax.xml.rpc.Stub)placeOrder_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bjtu.booking.osb.PlaceOrder_PortType getPlaceOrder_PortType() {
    if (placeOrder_PortType == null)
      _initPlaceOrderProxy();
    return placeOrder_PortType;
  }
  
  public com.bjtu.booking.osb.OrderResponse setOrder(com.bjtu.booking.osb.OrderType parameters) throws java.rmi.RemoteException{
    if (placeOrder_PortType == null)
      _initPlaceOrderProxy();
    return placeOrder_PortType.setOrder(parameters);
  }
  
  
}