package pe.upc.com.catchup.network

import java.net.URL

class LogoApi{
    companion object {
        val baseUrl = "https://logo.clearbit.com/"
        
        fun urlToLogo(url:String):String{
            return "$baseUrl${URL(url).host}"
        }
    }
}