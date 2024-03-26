package com.juane.ec3_juane_gil.dao

import androidx.room.*
import com.juane.ec3_juane_gil.model.Producto

@Dao
interface IProducto {
	@Query("SELECT * FROM producto")
	fun listProductos(): List<Producto>

	@Query("SELECT * FROM Producto WHERE id_producto LIKE '%' || :idProducto || '%'")
	fun findIdProducto(idProducto: Long): Producto

	@Transaction
	@Insert
	fun addProducto(producto: List<Producto>): List<Long>

	@Update
	fun updateProducto(producto: Producto): Int

	@Delete
	fun deleteProducto(producto: Producto): Int
}