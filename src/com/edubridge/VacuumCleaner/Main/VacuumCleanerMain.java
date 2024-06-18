package com.edubridge.VacuumCleaner.Main;

import java.util.List;
import java.util.Scanner;

import com.edubridge.VacuumCleaner.Services.VacuumCleanerServices;
import com.edubridge.VacuumCleaner.Services.VacuumCleanerServicesImpl;
import com.edubridge.VacuumCleaner.model.VacuumCleaner;


public class VacuumCleanerMain {

	public static void main(String[] args) {
		VacuumCleanerServices services = new VacuumCleanerServicesImpl();
		VacuumCleaner vc = null;
			
			Scanner in = new Scanner(System.in);
			int option;
			do {
				System.out.println("Welcome to VacuumCleaner App");
				System.out.println("***********************");
				System.out.println("1. Add VacuumCleaner");
				System.out.println("2. view VacuumCleaner");
				System.out.println("3. Search VacuumCleaner");
				System.out.println("4. Update VacuumCleaner");
				System.out.println("5. Delete VacuumCleaner");
				System.out.println("6. Delete All VacuumCleaner");
				System.out.println("7. Exit");
				System.out.println("Please choose the option");
				option = in.nextInt();
				
				switch(option) {
				case 1:
					System.out.println("Add New VacuumCleaner");
					System.out.println("------------------");
					System.out.println("Please enter Brand");
					String brand = in.next();
					System.out.println("Please enter FilterType");
					String filtertype =in.next();
					System.out.println("Please enter PowerSource");
					String powersource = in.next();
					System.out.println("Please enter Price");
				    Float price = in.nextFloat();
				    System.out.println("Please enter rating");
				    Float rating = in.nextFloat();
					
					vc = new VacuumCleaner();
					vc.setBrand(brand);
					vc.setFilterType(filtertype);
					vc.setpowersource(powersource);
					vc.setprice(price);
				    vc.setrating(rating);
					int status = services.addVacuumCleaner(vc);
					if(status == 1) {
						System.out.println("new VacuumCleaner added");
					}else {
						System.out.println("Something is wrong");
					}
					break;
				case 2:
					System.out.println("view  VacuumCleaner");
					List<VacuumCleaner> VacuumCleaners = services.findVacuumCleaner();
					
					System.out.println("Brand\tFilterType\tPowerSource\tPrice\tRating");
					System.out.println("----\t-----\t------");
					
					for(VacuumCleaner vacuumcleaner:VacuumCleaners) {
						System.out.println(vacuumcleaner.getBrand()+"\t"+vacuumcleaner.getfiltertype()+"\t"+vacuumcleaner.getpowersource()+"\t"+vacuumcleaner.getrating());
					}
					break;
				case 3:
					System.out.println("Search VacuumCleaner");
					System.out.println("please enter VacuumCleaner brand");
					String searchBrand = in.next();
					VacuumCleaner searchVacuumCleaner = services.findVacuumCleanerByBrand(searchBrand);
					if(searchVacuumCleaner != null) {
						System.out.println("Brand: "+searchVacuumCleaner.getBrand());
						System.out.println("FilterType: "+searchVacuumCleaner.getfiltertype());
						System.out.println("PowerSource: "+searchVacuumCleaner.getpowersource());
						System.out.println("Price: "+searchVacuumCleaner.getprice());
						System.out.println("rating: "+searchVacuumCleaner.getrating());
					}else {
						System.out.println("no VacuumCleaner found");
						
					}
					break;
				case 4:
					System.out.println("update VacuumCleaner");
					brand = in.next();
					searchVacuumCleaner = services.findVacuumCleanerByBrand(brand);
					
				    if(searchVacuumCleaner != null) {
				    	//displaying existing contact details
				    	System.out.println("Brand: "+searchVacuumCleaner.getBrand());
						System.out.println("FilterType: "+searchVacuumCleaner.getfiltertype());
						System.out.println("PowerSource: "+searchVacuumCleaner.getpowersource());
						System.out.println("Price: "+searchVacuumCleaner.getprice());
						System.out.println("Rating: "+searchVacuumCleaner.getrating());
					
						//reading contact update info
						System.out.println("please enter updated Brand");
						brand = in.next();
						System.out.println("please enter updated FilterType");
						filtertype = in.next();
						System.out.println("please enter updated PowerSource");
						powersource = in.next();
						System.out.println("please enter updated Price");
						price = in.nextFloat();
						System.out.println("please enter updated Rating");
						rating = in.nextFloat();
						
						VacuumCleaner updateVacuumCleaner = new VacuumCleaner();
						
						updateVacuumCleaner.setBrand(brand);
						updateVacuumCleaner.setFilterType(filtertype);
						updateVacuumCleaner.setpowersource(powersource);
						updateVacuumCleaner.setprice(price);
					    updateVacuumCleaner.setrating(rating);
						
						int updateStatus = services.updateVacuumCleaner(updateVacuumCleaner);
						if(updateStatus == 1) {
							System.out.println("VacuumCleaner Updated Successfully!");
						}else {
							System.out.println("something is wrong!");
						}
				    }else {
				    	System.out.println("No VacuumCleaner found with brand");
				    }
				    break;
				case 5:
					System.out.println("Delete VacuumCleaner");
					System.out.println("please enter VacuumCleaner brand:");
					searchBrand = in.next();
					
					searchVacuumCleaner = services.findVacuumCleanerByBrand(searchBrand);
					if(searchVacuumCleaner != null) {
						int deleteStatus = services.deleteVacuumCleanerByBrand(searchBrand);
						if(deleteStatus == 1) {
							System.out.println("Delete VacuumCleaner Successfully");
							
					}else {
						System.out.println("something is wrong!");
					}
				}else {
					System.out.println("No VacuumCleaner found");
				}
					break;
				case 6:
					System.out.println("Are You Sure Delete All VacuumCleaners?[Y/N]");
					String deleteConfirmStatus = in.next();
					if(deleteConfirmStatus.equalsIgnoreCase("Y")) {
						services.deleteAllVacuumCleaners();
						System.out.println("All VacuumCleaners Deleted!");
					}
					
					break;
				case 0:
					System.exit(0);
					break;
					default:
						System.out.println("Bye!!!");
						break;
				
				}
				
			}while(option!=0);
			}
		}