import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

// An immutable type representing a location on Earth.
public class Location implements Comparable<Location> {
    private final String loc; // location name
    private final double lat; // latitude
    private final double lon; // longitude

    // Construct a new location given its name, latitude, and longitude.
    public Location(String loc, double lat, double lon) {
        this.loc = loc;
        this.lat = lat;
        this.lon = lon;
    }

    // The great-circle distance between this location and that.
    public double distanceTo(Location that) {
        
    	double lat1 = Math.toRadians(lat);
    	double lon1 = Math.toRadians(lon);
    	double lat2 = Math.toRadians(that.lat);
    	double lon2 = Math.toRadians(that.lon);
    	
    	double d = 111 * Math.toDegrees(Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat2) * Math.cos(lon1 - lon2)));
    	return d;
    }

    // Is this location the same as that?
    public boolean equals(Location that) {
        
    	if (this.loc == that.loc) {
    		return true;
    	}
    	else if (this.lat == that.lat) {
    		return true;
    	}
    	
    	else if (this.lon == that.lon) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    	
    }

    // -1, 0, or 1 depending on whether the distance of this 
    // location to the origin (Parthenon, Athens, Greece @
    // 37.971525, 23.726726) is less than, equal to, or greater
    // than the distance of that location to the origin.
    public int compareTo(Location that) {
        
    	Location umass = new Location(" ", 42.3134, -71.0384);
    	double distanceToThis = distanceTo(umass);
    	double distanceToThat = umass.distanceTo(that);
    	
    	if (distanceToThis > distanceToThat) {
    		return 1;
    	}
    	
    	if (distanceToThis < distanceToThat) {
    		return -1;
    	}
    	
    	if (distanceToThis == distanceToThat) {
    		return 0;
    	}
    	
    	return 0;
    }

    // A string representation of the location, in "loc (lat, lon)" format.
    public String toString() {
        return String.format(loc + " (" + lat + ", " + lon + ")");
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int rank = Integer.parseInt(args[0]);
        double lat = Double.parseDouble(args[1]);
        double lon = Double.parseDouble(args[2]);        
        Location[] wonders = new Location[7];
        wonders[0] = new Location("The Great Wall of China (China)", 
                                  40.6769, 117.2319);
        wonders[1] = new Location("Petra (Jordan)", 30.3286, 35.4419);
        wonders[2] = new Location("The Colosseum (Italy)", 41.8902, 12.4923);
        wonders[3] = new Location("Chichen Itza (Mexico)", 20.6829, -88.5686);
        wonders[4] = new Location("Machu Picchu (Peru)", -13.1633, -72.5456);
        wonders[5] = new Location("Taj Mahal (India)", 27.1750, 78.0419);
        wonders[6] = new Location("Christ the Redeemer (Brazil)", 
                                  22.9519, -43.2106);
        Arrays.sort(wonders);
        for (Location wonder : wonders) {
            StdOut.println(wonder);
        }
        StdOut.println(wonders[rank].equals(new Location("", lat, lon)));
    }
}
