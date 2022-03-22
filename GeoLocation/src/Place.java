public class Place
{
    public String name;
    public String address;
    public GeoLocation location; 
    public Place(String n, String a, double lati, double longi)
    {
        name = n;
        address = a;
        location = new GeoLocation(lati, longi);
    }
    public Place (String n, String a, GeoLocation loc) {
       name = n; 
       address = a;
       location = new GeoLocation(loc.latitude, loc.longitude);
    }
    public double distanceTo(Place other) {
        return location.distanceTo(other.location);
    }
    public String toString() {
        String str = name + "\n" + address + "\n" + location.toString();
        return str;
     }
}
