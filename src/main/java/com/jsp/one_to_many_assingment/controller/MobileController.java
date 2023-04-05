package com.jsp.one_to_many_assingment.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.one_to_many_assingment.dto.Mobile;
import com.jsp.one_to_many_assingment.dto.Sim;
import com.jsp.one_to_many_assingment.service.MobileService;

public class MobileController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MobileService mobileService = new MobileService();
		
		for(;;) {
			
			System.out.println("1.Insert \n2. Update \n3. Display");
			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();
			
			switch(ch) {
			
			case 1: {
				
				Mobile mobile = new Mobile();
				
				System.out.println("Enter the Sim Id");
				int simId=sc.nextInt();
				
				System.out.println("Enter Mobile Id");
				mobile.setMobileId(sc.nextInt());
				
				System.out.println("Enter Mobile Brand");
				mobile.setMobileBrand(sc.next());
				
				System.out.println("Enter the MObile Model name.");
				String model = sc.next();
				model += sc.nextLine();
				mobile.setMobileModel(model);
				
				System.out.println("ENter the Mobile Price");
				mobile.setMobilePrice(sc.nextDouble());
				
				
				
				mobileService.saveMobile(mobile, simId);
			}break;
			
			case 2: {
				List<Mobile> list = mobileService.displayMobile();
				
				for (Mobile mobile : list) {
					
					System.out.println("::::::Mobile::::Details::::::");
					System.out.println("Mobile Id is : "+mobile.getMobileId());
					System.out.println("Mobile Brand is : "+mobile.getMobileBrand());
					System.out.println("Mobile Price is : "+mobile.getMobilePrice());
					System.out.println("Mobile Model is : "+mobile.getMobileModel());
					
					List<Sim> sim = mobile.getSim();
					
					for (Sim sim2 : sim) {
						
						System.out.println("::::::Sim::::::Details::::::");
						
						System.out.println("Sim Id is : "+sim2.getSimId());
						System.out.println("Sim Name is : "+sim2.getSimName());
						System.out.println("Sim Number is : "+sim2.getSimNumber());
					}
				}
			}break;
			}
		}
	}
}
