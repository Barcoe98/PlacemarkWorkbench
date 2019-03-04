package org.wit.placemark.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.placemark.models.PlacemarkModel
import org.wit.placemark.R
import kotlinx.android.synthetic.main.activity_main.*
import org.wit.placemark.main.MainApp

class PlacemarkActivity : AppCompatActivity(), AnkoLogger {

    var placemark = PlacemarkModel()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app = application as MainApp

        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)

        if (intent.hasExtra("placemark_edit")) {
           // btnAdd.settext("we")

            placemark = intent.extras.getParcelable<PlacemarkModel>("placemark_edit")
            placemarkTitle.setText(placemark.title)
            description.setText(placemark.description)
        }

        btnAdd.setOnClickListener() {
            placemark.title = placemarkTitle.text.toString()
            placemark.description = description.text.toString()
            if (placemark.title.isNotEmpty()) {
                ///app.placemarks.add(placemark.copy())
                app.placemarks.create(placemark.copy())
                info("add Button Pressed: $placemarkTitle")
                // app.placemarks.findAll().forEach{ info("add Button Pressed: ${it}") }
                setResult(AppCompatActivity.RESULT_OK)
                finish()

            }
            else {
                toast ("Please Enter a title")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

