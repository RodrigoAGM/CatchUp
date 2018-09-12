package pe.upc.com.catchup.models

import pe.upc.com.catchup.network.LogoApi


data class Source(
        val id: String,
        val name:String,
        val description:String?,
        val url:String?,
        val category:String?,
        val language:String?,
        val country:String?){

    val urlToLogo = "${LogoApi.urlToLogo(url!!)}"
}