package it.enesi.navigationbariconscolor

import android.app.Activity
import android.os.Build
import android.util.Log
import android.view.View
import android.view.WindowInsetsController
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "NavigationBarIconsColor")
class NavigationBarIconsColor : Plugin() {

    @PluginMethod
    fun setColor(call: PluginCall) {
        val color = call.getString("color")
        val activity = activity

        if (activity == null) {
            call.reject("Activity is null")
            return
        }

        activity.runOnUiThread {
            Log.d("NavigationBarIconsColor", "SDK Version: ${Build.VERSION.SDK_INT}")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                // Android 11 (API 30) e superiori
                val window = activity.window
                val controller = window.insetsController

                Log.d("NavigationBarIconsColor", "Usando WindowInsetsController")

                if (color != null && color == "dark") {
                    Log.d("NavigationBarIconsColor", "Impostazione icone scure (API 30+)")
                    controller?.setSystemBarsAppearance(
                        0,
                        WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
                    )
                } else {
                    Log.d("NavigationBarIconsColor", "Impostazione icone chiare (API 30+)")
                    controller?.setSystemBarsAppearance(
                        WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS,
                        WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
                    )
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Android 8.0 (API 26) fino ad Android 10
                val window = activity.window
                val decorView = window.decorView
                var flags = decorView.systemUiVisibility

                Log.d("NavigationBarIconsColor", "Usando SystemUiVisibility")
                Log.d("NavigationBarIconsColor", "Flags prima: $flags")

                flags = if (color != null && color == "dark") {
                    Log.d("NavigationBarIconsColor", "Impostazione icone scure (API 26-29)")
                    flags and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR.inv()
                } else {
                    Log.d("NavigationBarIconsColor", "Impostazione icone chiare (API 26-29)")
                    flags or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
                }

                Log.d("NavigationBarIconsColor", "Flags dopo: $flags")
                decorView.systemUiVisibility = flags
            }

            call.resolve()
        }
    }
}