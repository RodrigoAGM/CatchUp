package pe.upc.com.catchup.viewcontroller.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_source.view.*
import pe.upc.com.catchup.R
import pe.upc.com.catchup.models.Source

class SourcesAdapter(val sources:List<Source>, val context:Context):
        RecyclerView.Adapter<ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val source = sources.get(position)
        holder.nameTextView.text = source.name
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_source, parent, false))
    }

    override fun getItemCount(): Int {
        return sources.size
    }

}

class ViewHolder(view:View):RecyclerView.ViewHolder(view){
    val logoImageView = view.logoImageView
    val nameTextView = view.nameTextView
}