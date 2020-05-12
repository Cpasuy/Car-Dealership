package model;
import java.util.Scanner;
import java.util.ArrayList;
public class Company {
	//Constants
	public static final int SELLERS=10;
	public static final int ROW=10;
	public static final int COLUMN=5;
	//Atributes
	private String name;
	private String nit;
	private double total_earnings;
	private double sales_number;
	private Advisor[] sellers;
	private ArrayList<Vehicle>vehicles;
	private ArrayList<Client>waitingClients;
	private Vehicle [][]parkingLot;
	//Methods
	public Company(String name, String nit) {
		this.name=name;
		this.nit=nit;
		this.total_earnings=0;
		this.sales_number=0;
		this.sellers = new Advisor[SELLERS];
		this.vehicles=new ArrayList<Vehicle>();
		this.waitingClients=new ArrayList<Client>();
		this.parkingLot= new Vehicle[ROW][COLUMN];
	}
	public String getName() {
	return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public double getTotal_earnings() {
		return total_earnings;
	}
	public void setTotal_earnings(double total_earnings) {
		this.total_earnings = total_earnings;
	}
	public double getSales_number() {
		return sales_number;
	}
	public void setSales_number(double sales_number) {
		this.sales_number = sales_number;
	}
	public ArrayList<Vehicle> getVehicles(){
		return vehicles;
	}
	public Advisor searchAdvisor(String identification){
	Advisor searchAdvisor=null;
	boolean find=false;
	for (int s=0;s<SELLERS&&find==false;s++){
		if(sellers[s]!=null){
			if (sellers[s].getIdentification().equals(identification)){
			searchAdvisor=sellers[s];
			find=true;
			}
		}
	}
		return searchAdvisor;
    }
    public String addAdvisor(String name, String last_name, String identification)
	{   String message="";
		boolean add=false;
	    Advisor search=searchAdvisor(identification);
	    if (search!=null){
	    	message="Error. Avisor already exists.";
	    }
	    else
	    {
	   		for (int s=0;s<SELLERS&&add==false;s++){
	    		if (sellers[s]==null){
	    			sellers[s]=new Advisor(name,last_name,identification);
	    			add=true;
	    			message="The new advisor was successfully registered.";
	    	}
	    }
	    	if (add==false){
	    	message="Error.Cannot register more advisors";
	    	}
	    }
        return message;
	}
	public Client searchClient(String identification){
	Client searchClient=null;
	boolean find=false;
	boolean search=false;
	for(int s=0;s<SELLERS&&find==false;s++){
		if(sellers[s]!=null){
			Client []clients=new Client[Advisor.CLIENTS];
			clients=sellers[s].getClients();
			for(int m=0;m<Advisor.CLIENTS&&search==false;m++){
				if(clients[m]!=null){
					if(clients[m].getIdentification().equals(identification)){
						searchClient=clients[m];
						search=true;
						find=true;
					}
				}
			}	
		}
	}
		return searchClient;
    }
    public String addClient(String name, String last_name, String identification, String phone_number, String mail)
	{   String message="";
		boolean add=false;
	    Client search=searchClient(identification);
	    if (search!=null){
	    	message="Error. Client already exists.";
	    }
	    else{
	   		for (int m=0;m<SELLERS&& add==false;m++){
	   			if (sellers[m]!=null){
	   				Client []clients=new Client[Advisor.CLIENTS];
					clients=sellers[m].getClients();
					for(int s=0;s<Advisor.CLIENTS;s++){
						if(clients[s]==null){
	    					clients[s]=new Client(name,last_name,identification,phone_number,mail);
	    					add=true;
	    				}
	    			}
	    		}
	    	}
	    if(add==true){
	    	message="The new client was successfully registered.";
	    }
	    else{
	    	Client clients=new Client(name,last_name,identification,phone_number,mail);
	    	waitingClients.add(clients);
	    	}
	    }
        return message;
	}
	public boolean searchVehicle(String lisence_plate){
	boolean searchVehicle=false;
	boolean find=false;
	for (int s=0;s<vehicles.size()&&find==false;s++){
		if(vehicles.get(s)!=null){
			if(vehicles.get(s).getLisence_plate().equals(lisence_plate)){
			searchVehicle=true;
			find=true;
			}
		}
	}
		return searchVehicle;
    }
	public String addVehicle(double base_price,String brand,String model,double mileage,double cylinder,String type,String lisence_plate,String moto_type,double cap_tank,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		boolean find=false;
		boolean add=false;
		boolean park=false;
		String message="";
		if(lisence_plate.equals(Vehicle.VEHICLE_USED)){
		add=searchVehicle(lisence_plate);
		}
		int modelVehicle = Integer.parseInt(model);
				if(modelVehicle==2014){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][0]==null){
							Motocycle vehicles=new Motocycle(base_price,brand,model,mileage,cylinder,type,lisence_plate,moto_type,cap_tank,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][0]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2013){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][1]==null){
							Motocycle vehicles=new Motocycle(base_price,brand,model,mileage,cylinder,type,lisence_plate,moto_type,cap_tank,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][1]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2012){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][2]==null){
							Motocycle vehicles=new Motocycle(base_price,brand,model,mileage,cylinder,type,lisence_plate,moto_type,cap_tank,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][2]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2011){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][3]==null){
							Motocycle vehicles=new Motocycle(base_price,brand,model,mileage,cylinder,type,lisence_plate,moto_type,cap_tank,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][3]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle<2011){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][4]==null){
							Motocycle vehicles=new Motocycle(base_price,brand,model,mileage,cylinder,type,lisence_plate,moto_type,cap_tank,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][0]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
			else if(add==false || lisence_plate.equals("Not assigned")){
			Motocycle vehicles=new Motocycle(base_price,brand,model,mileage,cylinder,type,lisence_plate,moto_type,cap_tank,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
			this.vehicles.add(vehicles);
			find=true;
			}
		if(add==false){
			message="The vehicle has been successfully registered";
		}
		else if(park==true){
			message="The vehicle has been stored in the parking lot";
		}
		else if(add==true){
			message="The vehicle has not been successfully registered";
		}
		return message;
	}
	public String addVehicle(double base_price,String brand,String model,double mileage,double cylinder,String type,String lisence_plate,String car_type,int door_number,boolean polarized,double cap_tank,String type_gasoline,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		Scanner lector = new Scanner (System.in);
		boolean find=false;
		boolean add=false;
		boolean park=false;
		String message="";
		if(lisence_plate.equals(Vehicle.VEHICLE_USED)){
		add=searchVehicle(lisence_plate);
		}
		int modelVehicle = Integer.parseInt(model);
				if(modelVehicle==2014){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][0]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][0]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2013){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][1]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][1]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2012){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][2]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][2]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2011){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][3]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][3]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle<2011){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][4]==null){
							Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][4]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
			else if(add==false || lisence_plate.equals("Not assigned")){
					Gasoline vehicles=new Gasoline(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
					this.vehicles.add(vehicles);
					find=true;
			}
		if(add==false){
			message="The vehicle has been successfully registered";
		}
		else if(park==true){
			message="The vehicle has been stored in the parking lot";
		}
		else if(add==true){
			message="The vehicle has not been successfully registered";
		}
		return message;
	}
	public String addVehicle(double base_price,String brand,String model,double mileage,double cylinder,String type,String lisence_plate,String car_type,int door_number,boolean polarized,String charger_type,double duration,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		boolean find=false;
		boolean add=false;
		boolean park=false;
		String message="";
		if(lisence_plate.equals(Vehicle.VEHICLE_USED)){
		add=searchVehicle(lisence_plate);
		}
		int modelVehicle = Integer.parseInt(model);
				if(modelVehicle==2014){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][0]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][0]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2013){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][1]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][1]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2012){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][2]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][2]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2011){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][3]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][3]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle<2011){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][4]==null){
							Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][4]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
			else if(add==false || lisence_plate.equals("Not assigned")){
				Electrical vehicles=new Electrical(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
				this.vehicles.add(vehicles);
				find=true;
			}
		if(add==false){
			message="The vehicle has been successfully registered";
		}
		else if(park==true){
			message="The vehicle has been stored in the parking lot";
		}
		else if(add==true){
			message="The vehicle has not been successfully registered";
		}
		return message;
	}
	public String addVehicle(double base_price,String brand,String model,double mileage,double cylinder,String type,String lisence_plate,String car_type,int door_number,boolean polarized,double cap_tank,String type_gasoline,String charger_type,double duration,double priceSoat,String yearSoat,double coverage_amount,double priceMec,String yearMec,double gas_level){
		boolean find=false;
		boolean add=false;
		String message="";
		boolean park=false;
		if(lisence_plate.equals(Vehicle.VEHICLE_USED)){
		add=searchVehicle(lisence_plate);
		}
		int modelVehicle = Integer.parseInt(model);
				if(modelVehicle==2014){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][0]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][0]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2013){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][1]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][1]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2012){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][2]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][2]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle==2011){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][3]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][3]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
				else if(modelVehicle<2011){
					for(int m=0;m<parkingLot.length;m++){
						if(parkingLot[m][4]==null){
							Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
							parkingLot[m][4]=vehicles;
							this.vehicles.add(vehicles);
							park=true;
						}
					}
				}
			else if(add==false || lisence_plate.equals("Not assigned")){
				Hybrid vehicles=new Hybrid(base_price,brand,model,mileage,cylinder,type,lisence_plate,car_type,door_number,polarized,cap_tank,type_gasoline,charger_type,duration,priceSoat,yearSoat,coverage_amount,priceMec,yearMec,gas_level);
				this.vehicles.add(vehicles);
				find=true;
			}
		if(add==false){
			message="The vehicle has been successfully registered";
		}
		else if(park==true){
			message="The vehicle has been stored in the parking lot";
		}
		else if(add==true){
			message="The vehicle has not been successfully registered";
		}
		return message;
	}
	public String interest(String identificationA,String identificationC,String vehicle,String type){
		Advisor search=searchAdvisor(identificationA);
		String message="";
		ArrayList<Vehicle> interest;
		interest=new ArrayList<Vehicle>();
		if (search!=null){
	    	message="Error. Avisor doesnt exists.";
	    }
	    else{
	   		for (int s=0;s<SELLERS;s++){
	   			if(sellers[s].getIdentification().equals(identificationA)){
	   				Client [] clients=sellers[s].getClients();
	   				for(int m=0;m<Advisor.CLIENTS;m++){
	   					if(clients[m].getIdentification().equals(identificationC)){
	   						interest=clients[m].getInterest();
	   						if(type.equals(Vehicle.VEHICLE_NEW)){
								if(vehicle.equals("Motocycle")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(type) && vehicles.get(w) instanceof Motocycle){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Gasoline")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(type) && vehicles.get(w) instanceof Gasoline){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Electrical")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(type) && vehicles.get(w) instanceof Electrical){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Hybrid")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(type) && vehicles.get(w) instanceof Hybrid){
											interest.add(vehicles.get(w));
										}
									}
								}
							}
							else if(type.equals(Vehicle.VEHICLE_USED)){
								if(vehicle.equals("Motocycle")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(type) && vehicles.get(w) instanceof Motocycle){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Gasoline")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(type) && vehicles.get(w) instanceof Gasoline){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Electrical")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(type) && vehicles.get(w) instanceof Electrical){
											interest.add(vehicles.get(w));
										}
									}
								}
								else if(vehicle.equals("Hybrid")){
									for(int w=0;w<vehicles.size();w++){
										if(vehicles.get(w).getType().equals(type) && vehicles.get(w) instanceof Hybrid){
											interest.add(vehicles.get(w));
										}
									}
								}
							}
						}
					}
				}
			}
		}
		message=catalogue(vehicles,identificationC);
		return message;
	}
	public String catalogue( ArrayList<Vehicle> interest,String identification){
		String message="";
		Client objClient=searchClient(identification);
		if(objClient==null){
			message="The client doesn exist";
		}
		else{
			for(int s=0;s<interest.size();s++){
				message+=interest.get(s).toString()+"\n"+"\n";
			}
		}
		return message;
	}
	public String parkingInformation(String year){
		String message="";
		int modelVehicle = Integer.parseInt(year);
		if(modelVehicle==2014){
			for(int s=0;s<parkingLot.length;s++){
				message+=parkingLot[s][0].toString()+"\n";
			}
		}
		else if(modelVehicle==2013){
			for(int s=0;s<parkingLot.length;s++){
				message+=parkingLot[s][1].toString()+"\n";
			}
		}
		else if(modelVehicle==2012){
			for(int s=0;s<parkingLot.length;s++){
				message+=parkingLot[s][2].toString()+"\n";
			}
		}
		else if(modelVehicle==2011){
			for(int s=0;s<parkingLot.length;s++){
				message+=parkingLot[s][3].toString()+"\n";
			}
		}
		else if(modelVehicle<2011){
			for(int s=0;s<parkingLot.length;s++){
				message+=parkingLot[s][4].toString()+"\n";
			}
		}
		return message;
	}
	public String sellVehicle(String identificationA,String identificationC,String lisence_plate){
		String message="";
		ArrayList<Vehicle> interest;
		interest=new ArrayList<Vehicle>();
		Advisor search=searchAdvisor(identificationA);
		double priceVehicle=0;
		if (search!=null){
	    	message="Error. Advisor doesnt exists.";
	    }
	    else{
	    	for (int s=0;s<SELLERS;s++){
	   			if(sellers[s].getIdentification().equals(identificationA)){
	   				Client [] clients=sellers[s].getClients();
	   				for(int m=0;m<Advisor.CLIENTS;m++){
	   					if(clients[m].getIdentification().equals(identificationC)){
	   						interest=clients[m].getInterest();
	   						for(int w=0;w<interest.size();w++){
	   							if(interest.get(w).getLisence_plate().equals(lisence_plate)){
	   								interest.get(w).setClient(clients[m]);
	   								priceVehicle=interest.get(w).getTotal_price();
	   								int advisorSellers=sellers[s].getSales_quantity();
	   								sellers[s].setSales_quantity(advisorSellers+1);
	   								sales_number++;
	   							}
	   						}
	   					}						
					}
				}
			}
		message="The purchase has been successful, we are grateful for choosing us";
		total_earnings+=priceVehicle;
		}
		return message;
	}
}