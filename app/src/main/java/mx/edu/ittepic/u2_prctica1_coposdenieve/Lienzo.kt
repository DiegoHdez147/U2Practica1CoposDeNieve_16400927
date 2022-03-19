package mx.edu.ittepic.u2_prctica1_coposdenieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Lienzo (este:MainActivity): View(este){
    val este = este
    var viento = true
    var contador = rando(50)
    var contador2 = 0


    val corutina = GlobalScope.launch {
        while (true){
            este.runOnUiThread {
                invalidate()
            }
            delay(10L)
            if (contador <= 1000){
                contador++
            }
            if (contador >= 1001 ){
                contador--
            }
            if(contador >= 0 && contador <= 500){
                viento = false
                contador2++
            }
            if(contador >= 501 && contador <= 1000){
                viento = true
                contador2++
            }
            if(contador2 >= 100){
                contador = rando(1000)
                contador2 = 0
            }
            //if(contador){viento = true}
            //if(contador2 ){viento = false }
        }
    }

    val bolasdenieve = Array<Circulo>(200,{ Circulo(this) })
    val bolasdenieve2 = Array<Circulo>(400,{ Circulo(this) })

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        este.setTitle("ancho ${width} alto ${height} ono ${contador} ono2 ${contador2}")
        val p = Paint()

        //background
        c.drawColor(Color.BLACK)

        //Luna
        p.color = Color.rgb(195,195,195)
        c.drawCircle(160f,90f,380f,p)

        //montañas
        p.color = Color.rgb(20,62,20)
        c.drawCircle(720f,1950f,600f,p)
        c.drawCircle(300f,1990f,500f,p)

        //casa
        p.color = Color.rgb(203,50,52)
        c.drawRect(600F,1600F,900F,1800F,p)
        //techo
        p.color = Color.rgb(84,56,34)
        c.drawRect(540F,1560F,960F,1650F,p)
        //ventana
        p.color = Color.rgb(59,131,189)
        c.drawRect(780F,1696F,870F,1765F,p)
        //puerta
        p.color = Color.rgb(84,56,34)
        c.drawRect(620F,1700F,680F,1800F,p)

        //Tronco
        p.color = Color.rgb(84,56,34)
        c.drawRect(190F,1450F,250f,1620F,p)

        //arboles hoja
        p.color = Color.rgb(20,62,20)
        c.drawOval(140f,1230f,300f,1330f,p)
        c.drawOval(140f,1300f,300f,1400f,p)
        c.drawOval(140f,1370f,300f,1470f,p)

        if(viento) {
            for (nieve in bolasdenieve) {
                    nieve.nevada()
                    nieve.pintar(c)
            }
        }
        else{
            for (nieve in bolasdenieve2) {
                    nieve.vendisca()
                    nieve.pintar(c)
            }
        }
    }

    private fun rando(hasta:Int):Float{
        return Random.nextInt(hasta).toFloat()
    }



}