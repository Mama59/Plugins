package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import Model.Model;
import View.WindowsView;

public class Controleur implements Observer {

	private Model m;
	private WindowsView view;
	
	public Controleur(Model m, WindowsView view) {
		this.m = m;
		this.view = view;
	}

	@Override
	public void update(Observable m, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println(" model " + m+ " obj" +  arg1);
	}




}
