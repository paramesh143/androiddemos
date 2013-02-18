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
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity {
	EditText email;
	EditText password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		 email = (EditText)this.findViewById(R.id.email);
		 password = (EditText)this.findViewById(R.id.password);
	}
		public void newregister(View v) {
			Intent i=new Intent(this,SignUP.class);
			startActivity(i);
	}
	public void validation(View v)
	{
		String mail = email.getText().toString();
        String pswd = password.getText().toString();
	
    
            // TODO Auto-generated method stub
            //Add data to be send.
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("email", mail));
            nameValuePairs.add(new BasicNameValuePair("password",pswd));
            Log.d("sameek","validation");
            sendData(nameValuePairs);
        }
//executing the HttpPost
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
                    HttpPost httppost = new HttpPost("http://10.0.2.2:8080/Angellabs/validation");
                    httppost.setEntity(new UrlEncodedFormEntity(data));
                    HttpResponse response = httpclient.execute(httppost);
                    return EntityUtils.toString(response.getEntity());
                   /* InputStream is=response.getInputStream();
    		     	DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance(); 
    		    DocumentBuilder db=dbf.newDocumentBuilder();
    		    Document doc=db.parse(is);
    		    doc.getDocumentElement().normalize();
    		    NodeList nnls=doc.getElementsByTagName("users");
    		    Log.i("aaaaaa", "-------->doc ele: "+doc.getNodeName());
    		     StringBuffer sb=new StringBuffer();
    		     for(int i=0;i<nnls.getLength();i++)
    		     {
    		      Element el=(Element)nnls.item(i);
    		    String st=  el.getElementsByTagName("userneme").item(0).getTextContent();
    		    sb.append(st+" ");
    		    String st1=  el.getElementsByTagName("sex").item(0).getTextContent();
    		   sb.append(st1+" ");
    		   String st2=  el.getElementsByTagName("address").item(0).getTextContent();
    		    sb.append(st2+" ");
    		     String st3=el.getElementsByTagName("mail").item(0).getTextContent();
    		            }
    		     return sb.toString();   */
                    
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
				Toast.makeText(Home.this,result,Toast.LENGTH_LONG).show();
				super.onPostExecute(result);
			}

        }.execute();


    /* if(( uname.getText().toString()).equals( (password.getText().toString()))) {
		String url = "http://www.sameekshainfo.com";
		Intent login = new Intent(Intent.ACTION_VIEW);
		login.setData(Uri.parse(url));
		startActivity(login);
		  Toast.makeText(welcomesamee.this, "Login Successful",Toast.LENGTH_LONG).show();
     } else{
      Toast.makeText(welcomesamee.this, "Invalid Login",Toast.LENGTH_LONG).show();
     }
*/
	}
	
	}
