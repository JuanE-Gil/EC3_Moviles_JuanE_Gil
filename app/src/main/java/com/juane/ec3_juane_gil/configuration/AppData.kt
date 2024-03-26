package com.juane.ec3_juane_gil.configuration

import android.app.Application
import android.util.Log
import androidx.room.Room

class AppData : Application() {

	companion object {

		lateinit var db: Data
	}

	override fun onCreate() {
		super.onCreate()
		try {
			db = Room.databaseBuilder(
				this,
				Data::class.java,
				"Comercio"
			)
				.allowMainThreadQueries()
				.fallbackToDestructiveMigration()
				.build()
			Log.d("AppData", "The database has been created")
		} catch (e: Exception) {
			// Handle database creation error
			Log.e("AppData", "Failed to create database", e)
		}
	}

}

