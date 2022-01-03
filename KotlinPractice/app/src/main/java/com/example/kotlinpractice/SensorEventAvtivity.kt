package com.example.kotlinpractice

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SensorEventAvtivity:AppCompatActivity(), SensorEventListener{

    lateinit var sensorManager: SensorManager               //나중에 초기화 한다는 뜻

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrate)



    }

    override fun onResume() {
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL)
        super.onResume()
    }
    override fun onPause() {
        sensorManager.unregisterListener(this)
        super.onPause()
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val x = event?.values?.get(0) as Float
        val y = event?.values?.get(1) as Float
        val z = event?.values?.get(2) as Float
        println(x.toString()+", "+ y.toString()+", "+z.toString())
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}