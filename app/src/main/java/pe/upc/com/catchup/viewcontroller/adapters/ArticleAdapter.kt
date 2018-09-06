package pe.upc.com.catchup.viewcontroller.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_article.view.*
import pe.upc.com.catchup.R
import pe.upc.com.catchup.models.Article

class ArticleAdapter(val articles:List<Article>, val context: Context):
        RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles.get(position)
        TODO("Assign picture image")
        holder.titleTextView.text = article.title
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_article, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val pictureImageView = view.pictureImageView
        val titleTextView = view.titleTextView
    }

}

