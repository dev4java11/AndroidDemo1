package pe.com.wiverncorp.androiddemo1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.com.wiverncorp.androiddemo1.domain.Post;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etNombre = (EditText) findViewById(R.id.editText);
        etNombre.setText("HOLA MUNDO");

        PostHttpRequestTask stack = new PostHttpRequestTask();
        stack.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();
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

    public class PostHttpRequestTask extends AsyncTask<String, String, List<Post>>{

        @Override
        protected List<Post> doInBackground(String ... params) {
            try{
                String url = "https://jsonplaceholder.typicode.com/posts/";
                RestTemplate template = new RestTemplate();
                template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                System.out.println("Recuperando posts 1");
                Post[] array = template.getForObject(url, Post[].class);
                System.out.println("Recuperando posts 2");
                List<Post> posts = Arrays.asList(array);
                return posts;
            }catch (Exception ex){
                ex.printStackTrace();
                Log.e("MainActivity", ex.getMessage(), ex);
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Post> posts) {
            List<String> listPostString = new ArrayList<String>();
            for(Post post : posts){
                String cadena = "";
                cadena = cadena + "ID: " +post.getId()+"\n";
                cadena = cadena + "USER_ID: " +post.getUserId()+"\n";
                cadena = cadena + "TITLE: " +post.getTitle();
                //cadena = cadena + post.getBody();

                listPostString.add(cadena);
                cadena = "";
            }

            ListView listView = (ListView) findViewById(R.id.listView);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listPostString);
            listView.setAdapter(arrayAdapter);
        }
    }
}
