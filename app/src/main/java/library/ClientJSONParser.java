package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.beefnky.R;

public class ClientJSONParser {

	//Receives a JSONObject and returns a list
	public List<HashMap<String,Object>> parse(JSONObject jObject){
		
		JSONArray jClients = null;
		try{
			//Retrieves all the elements in the 'clients' array
			jClients = jObject.getJSONArray("clients");
		} catch (JSONException e){
			e.printStackTrace();
		}
		//Invoking getClients with the array of json object
		//where each json object represent a client
		return getClients(jClients);
	}
	
	private List<HashMap<String,Object>> getClients(JSONArray jClients){
		int clientCount = jClients.length();
		List<HashMap<String,Object>> clientList = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> client = null;
		
		//Taking each client, parses and adds to list object
		for(int i=0;i<clientCount;i++){
			try{
				//Call getClient with client JSON object to parse the client
				client = getClient((JSONObject)jClients.get(i));
				clientList.add(client);
			} catch (JSONException e){
				e.printStackTrace();
			}
		}
		return clientList;
	}
	
	//Parsing the Client JSON object
	private HashMap<String,Object> getClient(JSONObject jClient){
		HashMap<String,Object> client = new HashMap<String,Object>();
		String fullName = "";
		String email ="";
		String comments = "";
		String img_url = "";
		String category = "";
		
		try {
			fullName = jClient.getString("name");
			email = jClient.getString("email");
			comments = jClient.getString("comments");
			img_url = jClient.getString("img_url");
			category = jClient.getString("category");
					
			String details = 	"Email: " + email + "\n" + 
								"Comments : " + comments + "\n" +
								"Category : (" + category + ")";
			
			client.put("client", fullName);
			client.put("photo", R.drawable.ic_launcher);
			client.put("photo_path", img_url);
			client.put("details", details);
			//Log.d("JSON URL parsing", img_url.toString());
		} catch (JSONException e){
			e.printStackTrace();
		}
		return client;
	}
}