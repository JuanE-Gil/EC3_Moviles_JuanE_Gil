package com.juane.ec3_juane_gil.configuration

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juane.ec3_juane_gil.dao.IProducto
import com.juane.ec3_juane_gil.model.Producto

@Database(entities = [Producto::class], version = 1)
abstract class Data : RoomDatabase() {

	abstract fun daoProducto(): IProducto
}