package mx.edu.tpdm_u4u5_practica1_15401052

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener


class OyenteProximidad(p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(p0: SensorEvent?) {
        puntero.aux = p0!!.values[0]
    }
}