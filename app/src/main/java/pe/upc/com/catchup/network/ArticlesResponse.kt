package pe.upc.com.catchup.network

import pe.upc.com.catchup.models.Article

class ArticlesResponse{
    val status:String? = null
    val code:String? = null
    val message:String? = null
    val totalResults:Int? = null
    val articles:ArrayList<Article>? = ArrayList()
}