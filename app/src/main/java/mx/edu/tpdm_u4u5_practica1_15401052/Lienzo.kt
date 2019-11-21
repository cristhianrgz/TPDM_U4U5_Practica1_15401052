package mx.edu.tpdm_u4u5_practica1_15401052

import android.graphics.Canvas
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class Lienzo(p:MainActivity): View(p) {
    var puntero = p
    var picono : Imagen ?= null;

    //Imagenes originales
    var icon1 = Imagen(this,20f, 500f,R.drawable.icono1)
    var icon2 = Imagen(this,370f, 500f, R.drawable.icono2)
    var icon3 = Imagen(this, 720f, 500f, R.drawable.icono3)
    var icon4 = Imagen(this, 1070f, 500f, R.drawable.icono4)
    var icon5 = Imagen(this, 1420f, 500f, R.drawable.icono5)

    //Imagenes blanco y negro
    var bnicon1 = Imagen(this,20f, 500f,R.drawable.bn_icono1)
    var bnicon2 = Imagen(this,400f, 500f, R.drawable.bn_icono2)
    var bnicon3 = Imagen(this, 750f, 500f, R.drawable.bn_icono3)
    var bnicon4 = Imagen(this, 1100f, 500f, R.drawable.bn_icono4)
    var bnicon5 = Imagen(this, 1450f, 500f, R.drawable.bn_icono5)

    //Imagenes vintage
    var vicon1 = Imagen(this,50f, 500f,R.drawable.vicono1)
    var vicon2 = Imagen(this,400f, 500f, R.drawable.vicono2)
    var vicon3 = Imagen(this, 750f, 500f, R.drawable.vicono3)
    var vicon4 = Imagen(this, 1100f, 500f, R.drawable.vicono4)
    var vicon5 = Imagen(this, 1450f, 500f, R.drawable.vicono5)

    //Imagenes finder
    var finicon1 = Imagen(this, 50f, 500f, R.drawable.findericon1)
    var finicon2 = Imagen(this,400f, 500f, R.drawable.findericon2)
    var finicon3 = Imagen(this, 750f, 500f, R.drawable.findericon3)
    var finicon4 = Imagen(this, 1100f, 500f, R.drawable.findericon4)
    var finicon5 = Imagen(this, 1450f, 500f, R.drawable.findericon5)

    var arrListImagen = arrayListOf<Imagen>(icon1,icon2,icon3,icon4,icon5)
    var arrListImagenbn = arrayListOf<Imagen>(bnicon1,bnicon2,bnicon3,bnicon4,bnicon5)
    var arrListImagenvin = arrayListOf<Imagen>(vicon1,vicon2,vicon3,vicon4,vicon5)
    var arrListImagenfin = arrayListOf<Imagen>(finicon1,finicon2,finicon3,finicon4,finicon5)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        if(puntero.aux == 0f){
            icon1.visible = false
            icon2.visible = false
            icon3.visible = false
            icon4.visible = false
            icon5.visible = false
            invalidate()
        }
        else{
            when(puntero.aumentoShake){
                0 -> {
                    drawImgs(arrListImagen,c)
                    moverImagenes(arrListImagen, puntero.x)
                }
                1 -> {
                    drawImgs(arrListImagenbn,c)
                    moverImagenes(arrListImagenbn, puntero.x)
                }
                2 -> {
                    drawImgs(arrListImagenvin,c)
                    moverImagenes(arrListImagenvin, puntero.x)
                }
                3 -> {
                    drawImgs(arrListImagenfin,c)
                    moverImagenes(arrListImagenfin, puntero.x)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                if(icon1.estaEnArea(event.getX(), event.getY())|| bnicon1.estaEnArea(event.getX(), event.getY())
                    || vicon1.estaEnArea(event.getX(), event.getY()) ||finicon1.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste icono Instagram", Toast.LENGTH_SHORT).show()
                    picono = icon1
                }

                if(icon2.estaEnArea(event.getX(), event.getY())|| bnicon2.estaEnArea(event.getX(), event.getY())
                    || vicon2.estaEnArea(event.getX(), event.getY()) ||finicon2.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste a Larry", Toast.LENGTH_SHORT).show()
                    picono = icon2
                }

                if(icon3.estaEnArea(event.getX(), event.getY())|| bnicon3.estaEnArea(event.getX(), event.getY())
                    || vicon3.estaEnArea(event.getX(), event.getY()) ||finicon3.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste icono WhatsApp", Toast.LENGTH_SHORT).show()
                    picono = icon3
                }

                if(icon4.estaEnArea(event.getX(), event.getY())|| bnicon4.estaEnArea(event.getX(), event.getY())
                    || vicon4.estaEnArea(event.getX(), event.getY()) ||finicon4.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste icono Youtube", Toast.LENGTH_SHORT).show()
                    picono = icon4
                }

                if(icon5.estaEnArea(event.getX(), event.getY())|| bnicon5.estaEnArea(event.getX(), event.getY())
                    || vicon5.estaEnArea(event.getX(), event.getY()) ||finicon5.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste icono Facebook", Toast.LENGTH_SHORT).show()
                    picono = icon5
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {
                picono = null
            }
        }
        return true
    }

    fun moverImagenes(arrayImg : ArrayList<Imagen>, x:Float){
        arrayImg.forEach{
            it.mover(x)
        }
        invalidate()
    }

    fun hideImages(c: Canvas){
        c.restore()
        invalidate()
    }

    fun drawImgs(arrayImgs : ArrayList<Imagen>, c: Canvas){
        arrayImgs.forEach {
            it.pintar(c)
        }
    }
}