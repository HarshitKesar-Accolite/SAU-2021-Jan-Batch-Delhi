/**
 * Calculator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.harshit.assignment;

public interface Calculator extends java.rmi.Remote {
    public double log2(double value) throws java.rmi.RemoteException;
    public double sinOf(double value) throws java.rmi.RemoteException;
    public double cosOf(double value) throws java.rmi.RemoteException;
    public int factorial(double number) throws java.rmi.RemoteException;
    public double logBase(double value, int base) throws java.rmi.RemoteException;
    public double tanOf(double value) throws java.rmi.RemoteException;
}
