package com.juane.ec3_juane_gil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.juane.ec3_juane_gil.adapters.AdapterProducto
import com.juane.ec3_juane_gil.databinding.ActivityMainBinding
import com.juane.ec3_juane_gil.ui.FrmProductoActivity
import com.juane.ec3_juane_gil.viewModel.ViewProducto

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private lateinit var viewProducto: ViewProducto

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		viewProducto = ViewModelProvider(this).get()
		viewProducto.init()

		binding.rvProducto.apply {
			layoutManager = LinearLayoutManager(applicationContext)
		}

		viewProducto.list.observe(this) {
			binding.rvProducto.adapter = AdapterProducto(it)
		}

		binding.btnAgregar.setOnClickListener {
			val intent = Intent(this, FrmProductoActivity::class.java)
			intent.putExtra("opcion", 1)
			startActivity(intent)
		}
	}
}