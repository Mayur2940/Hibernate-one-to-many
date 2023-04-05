package com.jsp.one_to_many_assingment.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.one_to_many_assingment.dto.Sim;
import com.jsp.one_to_many_assingment.service.SimService;

public class SimController {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SimService simService = new SimService();
		
		for(;;)
		{
			System.out.println("1.Insert \n2. GetBySimId \n3. Display ");
			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();
			
			switch (ch) {
			
			case 1: {
				
				Sim sim = new Sim();
				
				System.out.println("Enter the Sim Id");
				sim.setSimId(sc.nextInt());
				
				System.out.println("Enter the Sim Name");
				sim.setSimName(sc.next());
				
				System.out.println("Enter the Sim Number");
				sim.setSimNumber(sc.nextLong());
				
				simService.insertSim(sim);
			}break;
			
			case 2: {
				System.out.println("Enter the Sim Id");
				int id = sc.nextInt();
				
				Sim sim = simService.getById(id);
				
				System.out.println("Sim ID = "+sim.getSimId());
				System.out.println("Sim Name = "+sim.getSimName());
				System.out.println("Sim Number = "+sim.getSimNumber());
			}break;
			
			case 3: {
				
					List<Sim> list = simService.displaySim();
					
					for (Sim sim : list) {
						
						System.out.println("Sim ID = "+sim.getSimId());
						System.out.println("Sim Name = "+sim.getSimName());
						System.out.println("Sim Number = "+sim.getSimNumber());
						System.out.println("==========================");
						
					}
				}
			}
		}
	}
}
