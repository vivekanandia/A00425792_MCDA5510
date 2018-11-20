/**
 * Servicemain.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mscd5510.web.service;

public interface Servicemain extends java.rmi.Remote {
    public java.lang.String getValues() throws java.rmi.RemoteException;
    public boolean updateValue(java.lang.String id, java.lang.String field, java.lang.String new_value) throws java.rmi.RemoteException;
    public boolean removeValue(java.lang.String id) throws java.rmi.RemoteException;
    public boolean insertValue(java.lang.String id, java.lang.String name, java.lang.String cardno, java.lang.String unitPrice, java.lang.String quantity, java.lang.String totalPrice, java.lang.String expDate) throws java.rmi.RemoteException;
}
