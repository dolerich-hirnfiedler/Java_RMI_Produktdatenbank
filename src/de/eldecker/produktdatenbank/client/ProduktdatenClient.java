package de.eldecker.produktdatenbank.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ProduktdatenClient {
	
	public static void main( String[] args ) throws RemoteException, 			       			 
                                                    NotBoundException {
		
		System.out.println();
		
		final Registry registry = LocateRegistry.getRegistry();
		
		// TODO Entferntes Objekt holen und Produkt mit Nr=222 abfragen
	}
	
}


