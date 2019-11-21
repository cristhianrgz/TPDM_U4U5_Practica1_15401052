package mx.edu.tpdm_u4u5_practica1_15401052

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var sensorManager : SensorManager?= null
    var oyenteProximidad : OyenteProximidad ?= null
    var oyenteAcelerometro : OyenteAcelerometro ?= null
    var oyenteShake : OyenteShake ?= null
    var x = 0f
    var aumentoShake = 0
    var aux = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        oyenteProximidad = OyenteProximidad(this)
        oyenteAcelerometro = OyenteAcelerometro(this)
        oyenteShake = OyenteShake(this)

        sensorManager?.registerListener(oyenteProximidad, sensorManager?.getDefaultSensor(Sensor.TYPE_PROXIMITY),
            SensorManager.SENSOR_DELAY_UI)

        sensorManager?.registerListener(oyenteAcelerometro, sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager?.registerListener(oyenteShake, sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_GAME)
    }
}
