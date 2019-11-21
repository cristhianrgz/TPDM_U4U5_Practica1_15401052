package mx.edu.tpdm_u4u5_practica1_15401052

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen(l:Lienzo, posx:Float, posy:Float, img:Int){
    var x = posx
    var y = posy
    var visible = true
    var imagen = BitmapFactory.decodeResource(l.resources,img)

    fun pintar(c: Canvas){
        c.drawBitmap(imagen, x, y, Paint())
    }

    fun estaEnArea(toquex:Float, toquey:Float): Boolean {
        var x2 = x + imagen.width
        var y2 = y + imagen.height

        if(toquex >= x && toquex <= x2){
            if(toquey >= y && toquey <= y2){
                return true
            }
        }
        return false
    }
    fun mover(xim:Float){
        x = x + xim
    }
}