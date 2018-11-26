package fr.wcs.apirestapp.listeners;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.wcs.apirestapp.MainActivity;

public class VolleyResponseListener implements Response.Listener<JSONObject> {

    @Override
    public void onResponse(JSONObject response) {
        Log.d("VOLLEY_RESPONSE", "onResponse : OK" );
        try {
            Handler myHandler = new Handler(  );
            StringBuffer description = new StringBuffer();
            JSONArray weatherOnFiveNextDays = response.getJSONArray("list");
            for (int i = 0; i < weatherOnFiveNextDays.length(); i+=8) {
                JSONObject weatherInfos = (JSONObject) weatherOnFiveNextDays.get( i );
                JSONArray weatherTab = (JSONArray) weatherInfos.get( "weather" );
                description.append("Jour " + (1 + i/8) + " "+ ((JSONObject)weatherTab.get( 0 ))
                        .getString( "description" ) + "\n\n");
            }
            myHandler.postDelayed( () -> MainActivity.myTextView.setText( description.toString() ), 50 );
        } catch (JSONException e) {
            Log.d("ERROR PARSING JSON", e.getMessage() );
        }
    }
}
