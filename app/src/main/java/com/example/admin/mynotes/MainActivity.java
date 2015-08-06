package com.example.admin.mynotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText titleTxt,descTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabH = (TabHost) findViewById(R.id.tabHost);
        tabH.setup();
        TabHost.TabSpec tabS = tabH.newTabSpec("list");
        tabS.setContent(R.id.listTab);
        tabS.setIndicator("My Notes");
        tabH.addTab(tabS);

        tabS = tabH.newTabSpec("newnote");
        tabS.setContent(R.id.addingTab);
        tabS.setIndicator("Add New Note");
        tabH.addTab(tabS);
        titleTxt = (EditText)findViewById(R.id.txtTitle);
        descTxt = (EditText)findViewById(R.id.txtDesc);

        final Button addBtn = (Button) findViewById(R.id.btnAdd);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Note has been added successfully...",Toast.LENGTH_SHORT).show();
            }
        });

        titleTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addBtn.setEnabled(!titleTxt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
