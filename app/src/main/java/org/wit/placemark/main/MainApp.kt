package org.wit.placemark.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.wit.placemark.models.PlacemarkModel
import org.jetbrains.anko.info
import org.wit.placemark.models.PlacemarkMemStore

class MainApp : Application(), AnkoLogger {

    // val placemarks = ArrayList<PlacemarkModel>()
    val placemarks = PlacemarkMemStore()


    override fun onCreate() {
        super.onCreate()
        info("Placemark started")
        //placemarks.add(PlacemarkModel("One", "About one..."))
        //placemarks.add(PlacemarkModel("Two", "About two..."))
        //placemarks.add(PlacemarkModel("Three", "About three..."))

    }


}