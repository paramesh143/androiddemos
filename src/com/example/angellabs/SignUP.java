package com.example.angellabs;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUP extends Activity implements View.OnClickListener {
    EditText uname, password,mail;
    Button submit;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //initializing variables
        setContentView(R.layout.signup);
        uname = (EditText) findViewById(R.id.name);
        mail = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.btnCreate);
        submit.setOnClickListener(this);
    }
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String un = uname.getText().toString();
                String pswd = password.getText().toString();
                String email = mail.getText().toString();
               
                                           
                    initializeData(un, pswd, email);
                
            }
          
         //in)itialization method to import the accessed data to the right columns in table  
                private void initializeData(String un, String pswd, 
                         String email ) {
        
      
     //in)itialization method to import the accessed data to the right columns in table  
           
                // TODO Auto-generated method stub
                //Add data to be send.
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
                nameValuePairs.add(new BasicNameValuePair("username", un));
                nameValuePairs.add(new BasicNameValuePair("password",pswd));
               nameValuePairs.add(new BasicNameValuePair("email",email));

             sendData(nameValuePairs);
            }
            
// executing the HttpPost
            private void sendData(final ArrayList<NameValuePair> data) {
                // TODO Auto-generated method stub
                 // 1) Connect via HTTP. 2) Encode data. 3) Send data.
            new AsyncTask<String,String,String>()
            {

				@Override
				protected String doInBackground(String... params) {
					// TODO Auto-generated method stub
					try
	                {
	                    HttpClient httpclient = new DefaultHttpClient();
	                    HttpPost httppost = new HttpPost("http://10.0.2.2:8080/Angellabs/register");
	                    httppost.setEntity(new UrlEncodedFormEntity(data));
	                    HttpResponse response = httpclient.execute(httppost);
	                    return EntityUtils.toString(response.getEntity());
	                }
	                catch(Exception e)
	                {
	                    Log.e("log_tag", "Error:  "+e.toString());
	                }
	                return null;
	            }

				@Override
				protected void onPostExecute(String result) {
					// TODO Auto-generated method stub
					Toast.makeText(SignUP.this,result,Toast.LENGTH_LONG).show();
					super.onPostExecute(result);
				}

            }.execute();


				}
            	
        }
    