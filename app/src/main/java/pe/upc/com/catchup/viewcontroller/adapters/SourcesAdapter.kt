package pe.upc.com.catchup.viewcontroller.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import javax.xml.transform.Source

class SourcesAdapter(val sources:List<Source>, val context:Context):
        RecyclerView.Adapter<ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
}

class ViewHolder(view:View):RecyclerView.ViewHolder(view){

}