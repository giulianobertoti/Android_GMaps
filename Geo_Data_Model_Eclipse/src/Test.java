import java.util.List;

import org.json.JSONException;


public class Test {

	public static void main(String[] args) throws JSONException {
		
		Connection con = new Connection();
		List<Marker> result = con.getData();
		
		
		System.out.println(result.get(0).getLat());
		
	}
	
}
