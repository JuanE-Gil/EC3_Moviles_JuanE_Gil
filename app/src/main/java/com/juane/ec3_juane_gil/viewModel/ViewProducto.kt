package com.juane.ec3_juane_gil.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juane.ec3_juane_gil.configuration.AppData.Companion.db
import com.juane.ec3_juane_gil.databinding.ActivityFrmProductoBinding
import com.juane.ec3_juane_gil.model.Producto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewProducto : ViewModel() {

	val list = MutableLiveData<List<Producto>>()

	// List All
	fun init() {
		viewModelScope.launch {
			list.value = withContext(Dispatchers.IO) {
				db.daoProducto().listProductos()
			}
		}
	}

	fun findCode(code: Long, ac: ActivityFrmProductoBinding) {
		viewModelScope.launch {
			val producto: Producto = withContext(Dispatchers.IO) {
				db.daoProducto().findIdProducto(code)
			}

			ac.txtDescripcion.setText(producto.descripcion)
			ac.txtPrecioCompra.setText(producto.precioCompra.toString())
			ac.txtPrecioVenta.setText(producto.precioVenta.toString())
			ac.txtStock.setText(producto.stock.toString())
		}
	}

	fun registerProducto(producto: Producto) {
		viewModelScope.launch {
			withContext(Dispatchers.IO) {
				db.daoProducto().addProducto(arrayListOf(producto))
				db.daoProducto().listProductos()
			}.also { list.value = it }
		}
	}

	fun updateProducto(producto: Producto) {
		viewModelScope.launch {
			var resp = withContext(Dispatchers.IO) {
				db.daoProducto().updateProducto(producto)
			}
		}
	}

	fun deleteProducto(producto: Producto) {
		viewModelScope.launch {
			var resp = withContext(Dispatchers.IO) {
				db.daoProducto().deleteProducto(producto)
			}
		}
	}
}