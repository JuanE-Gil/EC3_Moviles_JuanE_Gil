package com.juane.ec3_juane_gil.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juane.ec3_juane_gil.R
import com.juane.ec3_juane_gil.databinding.ItemProductoBinding
import com.juane.ec3_juane_gil.model.Producto
import com.juane.ec3_juane_gil.ui.FrmProductoActivity

class AdapterProducto(private val data: List<Producto>?) :
	RecyclerView.Adapter<AdapterProducto.ViewHolder>() {

	class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

		private val binding: ItemProductoBinding = ItemProductoBinding.bind(view)
		private var context: Context = view.context

		fun linkData(producto: Producto) {
			binding.lblCodigo.text = producto.idProducto.toString()
			binding.lblDescripcion.text = producto.descripcion
			binding.lblPrecioCompra.text = producto.precioCompra.toString()
			binding.lblPrecioVenta.text = producto.precioVenta.toString()
			binding.lblStock.text = producto.stock.toString()

			binding.root.setOnClickListener {
				val intent = Intent(context, FrmProductoActivity::class.java)
				intent.putExtra("opcion", 2)
				intent.putExtra("codigo", producto.idProducto)
				context.startActivity(intent)
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view =
			LayoutInflater.from(parent.context).inflate(R.layout.item_producto, parent, false)
		return ViewHolder(view)
	}

	override fun getItemCount(): Int = data?.size!!

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val reg: Producto? = data?.get(position)
		holder.linkData(reg!!)
	}
}