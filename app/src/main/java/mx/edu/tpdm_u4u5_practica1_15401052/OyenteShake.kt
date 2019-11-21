package mx.edu.tpdm_u4u5_practica1_15401052

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteShake(p:MainActivity): SensorEventListener {
    var puntero = p
    var fin: Long = 0
    var x = 0f
    var y = 0f
    var z = 0f
    var shX2 = 0f
    var shY2 = 0f
    var shZ2 = 0f
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(p0: SensorEvent?) {
        var temp : Long = System.currentTimeMillis()
        if((temp - fin) > 100){
            var diffTime = (temp - fin)
            fin = temp
            x = p0!!.values[0]
            y = p0!!.values[1]
            z = p0!!.values[2]

            var shakes : Float = Math.abs(x + y + z - shX2 - shY2 - shZ2) / diffTime * 10000

            if(shakes > 800){
                puntero.aumentoShake++
                if(puntero.aumentoShake > 3){
                    puntero.aumentoShake = 0
                }
            }
            shX2 = x
            shY2 = y
            shZ2 = z

        }
    }
}