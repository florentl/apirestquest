package fr.wcs.apirestapp.manager;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import fr.wcs.apirestapp.MainActivity;
import fr.wcs.apirestapp.listeners.VolleyResponseListener;

public class RestApiManager {

    private final static String API_KEY = "46b21ce99a86813fe1e08828d9d9ad40";

    public void addRequestQueue(String url) {

        url += "&APPID=" + API_KEY;

        Log.d("CALLING URL", url);

        // Crée une file d'attente pour les requêtes vers l'API
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.appContext);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new VolleyResponseListener(),
                err ->  Log.d("VOLLEY_ERROR", "onErrorResponse: " + err.getMessage()));

        requestQueue.add(jsonObjectRequest);
    }

}
