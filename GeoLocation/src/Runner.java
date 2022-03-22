public class Runner
{
   public static void main (String []args) {
      GeoLocation adminCoords = new GeoLocation(33.123961, -96.798735);
      System.out.println("Admin Building: " + adminCoords.toString());
      
      Place adminBuilding = new Place("Frisco ISD Admin Building", "5515 Ohio Dr, Frisco, TX 75035", adminCoords);
      System.out.println("Admin Building: " + adminBuilding.toString());
      
      Place schoolBuilding = new Place("Independence High School", "10555 Independence Pkwy, Frisco, TX 75035 ", 33.1645785, -96.7511102);
      System.out.println("School Building: " + schoolBuilding.toString());
      
      System.out.println("Distance beetween Admin & School Building: " + Math.round(adminBuilding.distanceTo(schoolBuilding) * 1000.0) / 1000.0);
   }
}