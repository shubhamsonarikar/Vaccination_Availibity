package com.example.vaccinationavailibity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String code, url;

    String date;
    EditText pin, inputd;
    Button button;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<model> modelArrayList;
    RecycleAdapter recycleAdapter;
    String baselink = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pin = findViewById(R.id.etext);
        inputd = findViewById(R.id.inputdate);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar2);
        recyclerView = findViewById(R.id.RecycleV);

        modelArrayList = new ArrayList<model>();
  onclickset();

    }

    private  void onclickset() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                code = pin.getText().toString();
                date = inputd.getText().toString();

                setdata();
            }
        });

    }

    public void setdata() {
        url = baselink + "?pincode=" + code + "&date=" + date;
        Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();
    fetch();
    }
    public void fetch()
    {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Toast.makeText(getApplicationContext(), "getting res", Toast.LENGTH_SHORT).show();
                    JSONObject obj = new JSONObject(response);
                    JSONArray arr = obj.getJSONArray("sessions");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject jsonObject = arr.getJSONObject(i);
                        model m = new model();
                        m.setAge(jsonObject.getString("age"));
                        Toast.makeText(getApplicationContext(), jsonObject.getString("age"), Toast.LENGTH_SHORT).show();

                        m.setAvail(jsonObject.getString("available_capacity"));
                        m.setFees(jsonObject.getString("fee"));
                        m.setCenter_name(jsonObject.getString("name"));
                        m.setLocation(jsonObject.getString("address"));
                        m.setTime(jsonObject.getString("from"));
                        m.setVaccine(jsonObject.getString("vaccine"));
                        modelArrayList.add(m);

                    }

                    RecycleAdapter recycleAdapter = new RecycleAdapter(modelArrayList, getApplicationContext());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerView.setAdapter(recycleAdapter);
                    progressBar.setVisibility(View.INVISIBLE);

                } catch (Exception e) {
                    progressBar.setVisibility(View.INVISIBLE);
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Sorry for Inconvinence", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}