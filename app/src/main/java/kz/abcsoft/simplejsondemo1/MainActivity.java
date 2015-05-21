package kz.abcsoft.simplejsondemo1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView JsonSrc = (TextView) findViewById(R.id.json_src);
        TextView JsonObject = (TextView) findViewById(R.id.json_object);
        TextView JsonResult = (TextView) findViewById(R.id.json_result);
        TextView JsonMyName = (TextView) findViewById(R.id.json_mysite);
        TextView JsonMyUrl = (TextView) findViewById(R.id.json_myurl);

        String json_source = getResources().getString(R.string.simple_json) ;

        JsonSrc.setText(json_source);

        try{
            JSONObject jsonObject = new JSONObject(json_source) ;
            JSONObject results = jsonObject.getJSONObject("results") ;
            String mySiteName = results.getString("sitename") ;
            String myUrl = results.getString("url") ;

            JsonObject.setText("\njsonObject:\n" + jsonObject.toString());
            JsonResult.setText("\nresults:\n" + results.toString());
            JsonMyName.setText("\nИмя сайта:\n" + mySiteName);
            JsonMyUrl.setText("\nАдрес сайта:\n" + myUrl);

        }catch(JSONException e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG)
                    .show();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
