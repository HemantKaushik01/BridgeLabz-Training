package com.in.futurelogistics;


abstract class GoodsTransport {
	private String transportId;
	private String transportDate;
	private int transportRating;
	 GoodsTransport(String transportId, String transportDate,int transportRating) {
		this.transportId=transportId;
		this.transportDate=transportDate;
		this.transportRating=transportRating;
	}
	 public String getTransportId() {
		 return transportId;
	 }
	 public void setTransportId(String transportId) {
		 this.transportId = transportId;
	 }
	 public String getTransportDate() {
		 return transportDate;
	 }
	 public void setTransportDate(String transportDate) {
		 this.transportDate = transportDate;
	 }
	 public int getTransportRating() {
		 return transportRating;
	 }
	 public void setTransportRating(int transportRating) {
		 this.transportRating = transportRating;
	 }
	 abstract  String vehicleSelection();
	 abstract  float calculateTotalCharge();
	 abstract void displayDetails();
	
}

class BrickTransport extends GoodsTransport{
	private float brickSize;
	private int brickQuantity;
	private float brickPrice;
	public BrickTransport(String transportId, String transportDate, int transportRating,float brickSize,int brickQuantity,float brickPrice) {
		
		super(transportId, transportDate, transportRating);
		this.brickSize=brickSize;
		this.brickPrice=brickPrice;
		this.brickQuantity=brickQuantity;

	}
	public float getBrickSize() {
		return brickSize;
	}
	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}
	public int getBrickQuantity() {
		return brickQuantity;
	}
	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}
	public float getBrickPrice() {
		return brickPrice;
	}
	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}
	
	@Override
	public String vehicleSelection() {	
		if(brickQuantity<300) {
			return "Truck";
		}
		else if(brickQuantity>=300 && brickQuantity<500) {
			return "Loory";
		}
		
		return "MosterLorry";
		
	}
	@Override
	public float calculateTotalCharge() {
		float price = brickQuantity*brickPrice;
		//brick cost after adding the cost which is 30%
		float tax = (float) (price*0.3);
		int discountPercentage=0;
		int transportRating =getTransportRating();
		if(transportRating==5) {
			discountPercentage=20;
		}
		else if(transportRating==3 || transportRating==4) {
			discountPercentage=10;
		}
		
		String brickType  = vehicleSelection().toLowerCase();
		int vehiclePrice=0;
		if(brickType.equals("truck")) {
			vehiclePrice=1000;
		}
		else if(brickType.equals("lorry")) {
			vehiclePrice=1700;
		}
		else {
			vehiclePrice=3000;
		}
		
		float discount = price*(discountPercentage/100);
		double totalCharge =(price +vehiclePrice+tax)-discount;
		
		return (float) totalCharge;
	}
	@Override
	public void displayDetails() {

	    System.out.println("---- Brick Transport Details ----");
	    System.out.println("Transport ID      : " + getTransportId());
	    System.out.println("Transport Date    : " + getTransportDate());
	    System.out.println("Transport Rating  : " + getTransportRating());
	    System.out.println("Brick Size        : " + brickSize);
	    System.out.println("Brick Quantity    : " + brickQuantity);
	    System.out.println("Brick Price       : " + brickPrice);
	    System.out.println("Vehicle Selected  : " + vehicleSelection());
	    System.out.println("Total Charge      : " + calculateTotalCharge());
	    System.out.println("--------------------------------");
	}

}
class TimberTransport extends GoodsTransport{
	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;
	public TimberTransport(String transportId, String transportDate, int transportRating, float trimberLength,String timerType,
			float timberRadius, float timberPrice) {
		super(transportId, transportDate, transportRating);
		this.timberLength = trimberLength;
		this.timberRadius = timberRadius;
		this.timberType=timerType;
		this.timberPrice = timberPrice;
	}
	public float getTrimberLength() {
		return timberLength;
	}
	public void setTrimberLength(float trimberLength) {
		this.timberLength = trimberLength;
	}
	public float getTimberRadius() {
		return timberRadius;
	}
	public void setTimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}
	public float getTimberPrice() {
		return timberPrice;
	}
	public void setTimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}
	double area = 2 *3.147 * timberRadius *timberLength;
	@Override
	public String vehicleSelection() {
		if(area<250) {
			return "Truck";
		}
		else if(area>=250 && area<400) {
			return "Lorry";
			
		}
		return "MosterLorry";
	}
	@Override
	public float calculateTotalCharge() {
		double volume = 3.147 * timberRadius * timberRadius * timberLength;
		double price = volume * timberPrice * (timberType=="Premium"?0.25:0.15);
		double tax = price*0.3;
		int discountPercentage=0;
		int transportRating =getTransportRating();
		if(transportRating==5) {
			discountPercentage=20;
		}
		else if(transportRating==3 || transportRating==4) {
			discountPercentage=10;
		}
		double discount =price*discountPercentage/100;
		String brickType  = vehicleSelection().toLowerCase();
		int vehiclePrice=0;
		if(brickType.equals("truck")) {
			vehiclePrice=1000;
		}
		else if(brickType.equals("lorry")) {
			vehiclePrice=1700;
		}
		else {
			vehiclePrice=3000;
		}
		
		double totalCharge =((price)+vehiclePrice+tax)-discount;
		return (float)totalCharge;
	}
	@Override
	public void displayDetails() {

	    System.out.println("---- Timber Transport Details ----");
	    System.out.println("Transport ID      : " + getTransportId());
	    System.out.println("Transport Date    : " + getTransportDate());
	    System.out.println("Transport Rating  : " + getTransportRating());
	    System.out.println("Timber Length     : " + timberLength);
	    System.out.println("Timber Radius     : " + timberRadius);
	    System.out.println("Timber Type       : " + timberType);
	    System.out.println("Timber Price      : " + timberPrice);
	    System.out.println("Vehicle Selected  : " + vehicleSelection());
	    System.out.println("Total Charge      : " + calculateTotalCharge());
	    System.out.println("---------------------------------");
	}

	
}

class TransportUtility {

    public GoodsTransport parseDetails(String input) {

        String[] data = input.split(",");

        String transportId = data[0];
        String transportDate = data[1];
        int transportRating = Integer.parseInt(data[2]);
        String transportType = data[3];

        if (!validateTransportId(transportId)) {
            return null;
        }

        if (transportType.equalsIgnoreCase("BrickTransport")) {

            float brickSize = Float.parseFloat(data[4]);
            int brickQuantity = Integer.parseInt(data[5]);
            float brickPrice = Float.parseFloat(data[6]);

            return new BrickTransport(
                    transportId,
                    transportDate,
                    transportRating,
                    brickSize,
                    brickQuantity,
                    brickPrice
            );
        }

        else if (transportType.equalsIgnoreCase("TimberTransport")) {

            float timberLength = Float.parseFloat(data[4]);
            String timberType = data[5];
            float timberRadius = Float.parseFloat(data[6]);
            float timberPrice = Float.parseFloat(data[7]);

            return new TimberTransport(
                    transportId,
                    transportDate,
                    transportRating,
                    timberLength,
                    timberType,
                    timberRadius,
                    timberPrice
            );
        }

        return null;
    }

    public boolean validateTransportId(String transportId) {

        if (transportId.matches("RTS[0-9]{3}[A-Z]")) {
            return true;
        } else {
            System.out.println("Transport Id " + transportId + " is invalid");
            return false;
        }
    }

    public String findObjectType(GoodsTransport goodsTransport) {

        if (goodsTransport instanceof TimberTransport) {
            return "TimberTransport";
        }
        else if (goodsTransport instanceof BrickTransport) {
            return "BrickTransport";
        }

        return "Unknown Transport Type";
    }
}

public class FutureLogistics {

    public static void main(String[] args) {

        TransportUtility utility = new TransportUtility();

       
        String brickInput =
            "RTS123A,2025-01-20,5,BrickTransport,10.5,450,8.0";

        GoodsTransport brickTransport = utility.parseDetails(brickInput);

        if (brickTransport != null) {
            System.out.println("Object Type: " + utility.findObjectType(brickTransport));
            brickTransport.displayDetails();   
        }

        System.out.println();

        
        String timberInput =
            "RTS456B,2025-01-22,4,TimberTransport,12.5,Premium,3.2,150";

        GoodsTransport timberTransport = utility.parseDetails(timberInput);

        if (timberTransport != null) {
            System.out.println("Object Type: " + utility.findObjectType(timberTransport));
            timberTransport.displayDetails();  
        }
    }
}

