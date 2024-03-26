package com.juane.ec3_juane_gil.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.juane.ec3_juane_gil.MainActivity
import com.juane.ec3_juane_gil.databinding.ActivityFrmProductoBinding
import com.juane.ec3_juane_gil.model.Producto
import com.juane.ec3_juane_gil.viewModel.ViewProducto

class FrmProductoActivity : AppCompatActivity() {

	private lateinit var binding: ActivityFrmProductoBinding
	private lateinit var viewProducto: ViewProducto

	private var cod: Long = -1

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityFrmProductoBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val data = intent.extras
		val opcion = data?.getInt("opcion")

		binding.btnGuardar.visibility = View.INVISIBLE

		if (opcion == 1) {
			binding.btnGuardar.visibility = View.VISIBLE
			binding.btnActualizar.visibility = View.INVISIBLE
			binding.btnEliminar.visibility = View.INVISIBLE
		}

		if (opcion == 2) {
			cod = data.getLong("codigo").toLong()
			viewProducto = ViewModelProvider(this).get()

			viewProducto.findCode(cod, binding)
		}

		binding.btnGuardar.setOnClickListener {
			val producto = Producto(
				0,
				binding.txtDescripcion.text.toString(),
				binding.txtPrecioCompra.text.toString().toDouble(),
				binding.txtPrecioVenta.text.toString().toDouble(),
				binding.txtStock.text.toString().toInt()
			)

			viewProducto = ViewModelProvider(this).get()
			viewProducto.registerProducto(producto)

			val intent = Intent(this, MainActivity::class.java)
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
			startActivity(intent)
		}

		binding.btnActualizar.setOnClickListener {
			val producto = Producto(
				cod,
				binding.txtDescripcion.text.toString(),
				binding.txtPrecioCompra.text.toString().toDouble(),
				binding.txtPrecioVenta.text.toString().toDouble(),
				binding.txtStock.text.toString().toInt()
			)

			viewProducto = ViewModelProvider(this).get()
			viewProducto.updateProducto(producto)

			val intent = Intent(this, MainActivity::class.java)
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
			startActivity(intent)
		}

		binding.btnEliminar.setOnClickListener {
			val producto = Producto(
				cod,
				binding.txtDescripcion.text.toString(),
				binding.txtPrecioCompra.text.toString().toDouble(),
				binding.txtPrecioVenta.text.toString().toDouble(),
				binding.txtStock.text.toString().toInt()
			)

			viewProducto = ViewModelProvider(this).get()
			viewProducto.deleteProducto(producto)

			val intent = Intent(this, MainActivity::class.java)
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
			startActivity(intent)
		}
	}
}