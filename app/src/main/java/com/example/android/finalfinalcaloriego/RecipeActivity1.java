package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class RecipeActivity1 extends AppCompatActivity {
    TextView newstitle;
    TextView newstext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe1);
        newstitle = findViewById(R.id.article_subheading);
        newstext1 = findViewById(R.id.article);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getString("some") != null) {
                Toast.makeText(getApplicationContext(),
                        "data:" + bundle.getString("some"),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String subject = newstitle.getText().toString();
        String text=newstext1.getText().toString();
        switch (item.getItemId()) {

            case R.id.action_send:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, text);

                startActivity(Intent.createChooser(intent, "Send Email"));

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}