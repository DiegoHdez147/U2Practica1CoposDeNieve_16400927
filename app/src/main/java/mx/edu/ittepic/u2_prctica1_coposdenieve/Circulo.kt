package mx.edu.ittepic.u2_prctica1_coposdenieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Circulo(l: Lienzo) {
    val l = l
    var x = 0f
    var y = 0f
    var movX = 0f
    var movY = 0f
    var tamano = 0f
    var iniciox = 0f
    var conta = 0

    //init es un construccion
    init {
        x = rando(1800)
        iniciox = x
        y = rando(2046)
        tamano = rando(15)+4
    }

    private fun rando(hasta:Int):Float{
        return Random.nextInt(hasta).toFloat()
    }

    fun nevada (){
            if (y <= 2051) {
                movY = rando(7) + 3
                y += movY
                conta++
            }
            if (y > 2051) {
                y += rando(2400) * -1
            }
    }

    fun vendisca (){
            if (y <= 2051) {
                movY = rando(30) + 3
                y += movY
                movX = 4f
                x += movX
            }
            if (y > 2051) {
                y += rando(2400) * -1
                x = iniciox
            }
    }

    fun pintar (canvas : Canvas){
        var p = Paint()
        p.color = Color.WHITE
        canvas.drawCircle(x,y,tamano,p)
    }

}