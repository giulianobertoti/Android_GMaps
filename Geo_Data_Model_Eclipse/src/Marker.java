public class Marker {

    private Double lat;
    private Double lon;

    public Marker(Double l, Double lo){
        lat = l;
        lon = lo;
    }

    public Double getLat(){
        return lat;
    }

    public Double getLon(){
        return lon;
    }
}