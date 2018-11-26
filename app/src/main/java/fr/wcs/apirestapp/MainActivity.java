package fr.wcs.apirestapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import fr.wcs.apirestapp.manager.RestApiManager;

public class MainActivity extends AppCompatActivity {

    public static Context appContext;
    public static TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        appContext = getApplicationContext();
        myTextView=findViewById(R.id.myTextView);
        String url = "https://api.openweathermap.org/data/2.5/forecast?q=Toulouse";
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.addRequestQueue( url );
    }
}
