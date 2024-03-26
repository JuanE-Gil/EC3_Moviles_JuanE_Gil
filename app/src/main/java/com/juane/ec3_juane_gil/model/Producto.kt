package com.juane.ec3_juane_gil.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Producto(

	@ColumnInfo(name = "id_producto")
	@PrimaryKey(autoGenerate = true)
	var idProducto: Long,

	@ColumnInfo(name = "descripcion")
	val descripcion: String,

	@ColumnInfo(name = "precio_compra")
	val precioCompra: Double,

	@ColumnInfo(name = "precio_venta")
	val precioVenta: Double,

	@ColumnInfo(name = "stock")
	val stock: Int
)