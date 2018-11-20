package com.mscd5510.web.service;

public class ServicemainProxy implements com.mscd5510.web.service.Servicemain {
  private String _endpoint = null;
  private com.mscd5510.web.service.Servicemain servicemain = null;
  
  public ServicemainProxy() {
    _initServicemainProxy();
  }
  
  public ServicemainProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicemainProxy();
  }
  
  private void _initServicemainProxy() {
    try {
      servicemain = (new com.mscd5510.web.service.ServicemainServiceLocator()).getServicemain();
      if (servicemain != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicemain)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicemain)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicemain != null)
      ((javax.xml.rpc.Stub)servicemain)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mscd5510.web.service.Servicemain getServicemain() {
    if (servicemain == null)
      _initServicemainProxy();
    return servicemain;
  }
  
  public java.lang.String getValues() throws java.rmi.RemoteException{
    if (servicemain == null)
      _initServicemainProxy();
    return servicemain.getValues();
  }
  
  public boolean updateValue(java.lang.String id, java.lang.String field, java.lang.String new_value) throws java.rmi.RemoteException{
    if (servicemain == null)
      _initServicemainProxy();
    return servicemain.updateValue(id, field, new_value);
  }
  
  public boolean removeValue(java.lang.String id) throws java.rmi.RemoteException{
    if (servicemain == null)
      _initServicemainProxy();
    return servicemain.removeValue(id);
  }
  
  public boolean insertValue(java.lang.String id, java.lang.String name, java.lang.String cardno, java.lang.String unitPrice, java.lang.String quantity, java.lang.String totalPrice, java.lang.String expDate) throws java.rmi.RemoteException{
    if (servicemain == null)
      _initServicemainProxy();
    return servicemain.insertValue(id, name, cardno, unitPrice, quantity, totalPrice, expDate);
  }
  
  
}