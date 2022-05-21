package com.example.scrollinfinitokotlin

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var nsvVista: NestedScrollView
    lateinit var rvUsuarios: RecyclerView
    lateinit var pbCargando: ProgressBar

    var contador = 0
    var aux = 0
    var listaUsuarios: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nsvVista = findViewById(R.id.nsvVista)
        rvUsuarios = findViewById(R.id.rvUsuarios)
        rvUsuarios.layoutManager = GridLayoutManager(this, 1)
        pbCargando = findViewById(R.id.pbCargando)

        obtenerUsuarios(rvUsuarios, this)

        nsvVista.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener {
                v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                contador++
                pbCargando.visibility = View.VISIBLE
                Handler().postDelayed(Runnable {
                    if (contador < 10) {
                        obtenerUsuarios(rvUsuarios, this@MainActivity)
                    }
                }, 3000)
            }
        })
    }

    fun obtenerUsuarios(rvUsuarios: RecyclerView, context: Context) {
        for (i in 1..10) {
            aux++
            listaUsuarios.add("Usuario con ID: $aux")
        }

        rvUsuarios.adapter = AdaptadorUsuarios(listaUsuarios)
    }
}