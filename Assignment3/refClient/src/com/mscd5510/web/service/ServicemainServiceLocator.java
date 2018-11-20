/**
 * ServicemainServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mscd5510.web.service;

public class ServicemainServiceLocator extends org.apache.axis.client.Service implements com.mscd5510.web.service.ServicemainService {

    public ServicemainServiceLocator() {
    }


    public ServicemainServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicemainServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Servicemain
    private java.lang.String Servicemain_address = "http://localhost:8081/ref/services/Servicemain";

    public java.lang.String getServicemainAddress() {
        return Servicemain_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicemainWSDDServiceName = "Servicemain";

    public java.lang.String getServicemainWSDDServiceName() {
        return ServicemainWSDDServiceName;
    }

    public void setServicemainWSDDServiceName(java.lang.String name) {
        ServicemainWSDDServiceName = name;
    }

    public com.mscd5510.web.service.Servicemain getServicemain() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Servicemain_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicemain(endpoint);
    }

    public com.mscd5510.web.service.Servicemain getServicemain(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mscd5510.web.service.ServicemainSoapBindingStub _stub = new com.mscd5510.web.service.ServicemainSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicemainWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicemainEndpointAddress(java.lang.String address) {
        Servicemain_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.mscd5510.web.service.Servicemain.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mscd5510.web.service.ServicemainSoapBindingStub _stub = new com.mscd5510.web.service.ServicemainSoapBindingStub(new java.net.URL(Servicemain_address), this);
                _stub.setPortName(getServicemainWSDDServiceName());
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
        if ("Servicemain".equals(inputPortName)) {
            return getServicemain();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.web.mscd5510.com", "ServicemainService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.web.mscd5510.com", "Servicemain"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Servicemain".equals(portName)) {
            setServicemainEndpointAddress(address);
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
