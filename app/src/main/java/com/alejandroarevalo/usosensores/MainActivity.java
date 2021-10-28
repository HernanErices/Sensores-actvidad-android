package com.alejandroarevalo.usosensores;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener{
    //ACCELEROMETRO
    private SensorManager SensorManager;
    private Sensor Acelerometro, magnetometer;
    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ACCELEROMETRO
        SensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Acelerometro = SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorManager.registerListener(this, Acelerometro , SensorManager.SENSOR_DELAY_NORMAL);

        magnetometer = SensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        SensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;
        //ACCELEROMETRO
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];
                tv1 = findViewById(R.id.tv_acelerometro);
                tv1.setText("X: " + x + "\n" + "Y: "+ y+ "\n"  + "Z:"+z );
            }
        }

        if (event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
            if (mySensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];
                tv2 = findViewById(R.id.tv_magnetometer);
                tv2.setText("X: " + x + " μT" + "\n" + "Y: "+ y + " μT"+ "\n"   +"Z:"+z + " μT");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}