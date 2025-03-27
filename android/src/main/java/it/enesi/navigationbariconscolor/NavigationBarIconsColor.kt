package it.enesi.navigationbariconscolor

import android.os.Build
import android.util.Log
import android.view.Window
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
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

            val window: Window = activity.window
            val windowInsetsController: WindowInsetsControllerCompat =
                WindowCompat.getInsetsController(window, window.decorView)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Android 8.0 (API 26) e superiori
                Log.d("NavigationBarIconsColor", "Usando WindowInsetsControllerCompat")

                windowInsetsController.isAppearanceLightNavigationBars =
                    color != "dark"

                Log.d(
                    "NavigationBarIconsColor",
                    "Impostazione icone ${if (color != "dark") "chiare" else "scure"} (API 26+)"
                )
            } else {
                Log.w(
                    "NavigationBarIconsColor",
                    "Impossibile impostare il colore delle icone della barra di navigazione su versioni precedenti ad Android 8.0 (API 26)"
                )
            }

            call.resolve()
        }
    }
}