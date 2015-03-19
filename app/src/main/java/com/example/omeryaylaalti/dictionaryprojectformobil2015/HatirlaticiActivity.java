package com.example.omeryaylaalti.dictionaryprojectformobil2015;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class HatirlaticiActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hatirlatici);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Hatırlatıcı, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        // Your code here
                        int iSelection = adapterView.getSelectedItemPosition();

                        if(iSelection==0){
                            int j = 1;
                            Intent intent = new Intent(HatirlaticiActivity.this,MyBroadcastReceiver.class);
                            PendingIntent pendingIntent= PendingIntent.getBroadcast(getApplicationContext(),21312122,intent,0);
                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+
                                    (j*60*1000),pendingIntent);
                            Toast.makeText(adapterView.getContext(), "Hatırlatıcımız " + j + " dakika devreye girecek.", Toast.LENGTH_LONG).show();
                        }else if(iSelection==1) {
                            Intent intent = new Intent(HatirlaticiActivity.this,MyBroadcastReceiver.class);
                            PendingIntent pendingIntent= PendingIntent.getBroadcast(getApplicationContext(),21312122,intent,0);
                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                            int j = 5;
                            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                                    (j*60*1000), pendingIntent);
                            Toast.makeText(adapterView.getContext(), "Hatırlatıcımız " + j + " dakika devreye girecek.", Toast.LENGTH_LONG).show();
                        }else if(iSelection==2) {
                            Intent intent = new Intent(HatirlaticiActivity.this,MyBroadcastReceiver.class);
                            PendingIntent pendingIntent= PendingIntent.getBroadcast(getApplicationContext(),21312122,intent,0);
                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                            int j = 10;
                            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                                    (j*60*1000), pendingIntent);
                            Toast.makeText(adapterView.getContext(), "Hatırlatıcımız " + j + " dakika devreye girecek.", Toast.LENGTH_LONG).show();
                        }else if(iSelection==3) {
                            Intent intent = new Intent(HatirlaticiActivity.this,MyBroadcastReceiver.class);
                            PendingIntent pendingIntent= PendingIntent.getBroadcast(getApplicationContext(),21312122,intent,0);
                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                            int j = 15;
                            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                                    (j*60*1000), pendingIntent);
                            Toast.makeText(adapterView.getContext(), "Hatırlatıcımız " + j + " dakika devreye girecek.", Toast.LENGTH_LONG).show();
                        }else if(iSelection==4) {
                            Intent intent = new Intent(HatirlaticiActivity.this,MyBroadcastReceiver.class);
                            PendingIntent pendingIntent= PendingIntent.getBroadcast(getApplicationContext(),21312122,intent,0);
                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                            int j = 20;
                            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                                    (j*60*1000), pendingIntent);
                            Toast.makeText(adapterView.getContext(), "Hatırlatıcımız " + j + " dakika devreye girecek.", Toast.LENGTH_LONG).show();
                        }else if(iSelection==5) {
                            Intent intent = new Intent(HatirlaticiActivity.this,MyBroadcastReceiver.class);
                            PendingIntent pendingIntent= PendingIntent.getBroadcast(getApplicationContext(),21312122,intent,0);
                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                            int j = 30;
                            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                                    (j*60*1000), pendingIntent);
                            Toast.makeText(adapterView.getContext(), "Hatırlatıcımız " + j + " dakika devreye girecek.", Toast.LENGTH_LONG).show();
                        }else if(iSelection==6) {
                            Intent intent = new Intent(HatirlaticiActivity.this,MyBroadcastReceiver.class);
                            PendingIntent pendingIntent= PendingIntent.getBroadcast(getApplicationContext(),21312122,intent,0);
                            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                            int j =60;
                            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                                    (j*60*1000), pendingIntent);
                            Toast.makeText(adapterView.getContext(), "Hatırlatıcımız " + j + " dakika devreye girecek.", Toast.LENGTH_LONG).show();
                        }

                }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hatirlatici, menu);
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
