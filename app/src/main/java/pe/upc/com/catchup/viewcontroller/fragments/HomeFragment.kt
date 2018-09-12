package pe.upc.com.catchup.viewcontroller.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.json.JSONObject

import pe.upc.com.catchup.R
import pe.upc.com.catchup.models.Article
import pe.upc.com.catchup.network.NewsApi
import pe.upc.com.catchup.viewcontroller.adapters.ArticleAdapter

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val articlesRecyclerView = view.articlesRecyclerView
        val articles = ArrayList<Article>()
        val articlesAdapter = ArticleAdapter(articles, view.context)
        val articlesLayoutManager = GridLayoutManager(view.context,2)
        articlesRecyclerView.adapter = articlesAdapter
        articlesRecyclerView.layoutManager = articlesLayoutManager
        val tag = "CatchUp"
        AndroidNetworking.get(NewsApi.topHeadlinesUrl)
                .addQueryParameter("apiKey", getString(R.string.news_api_key))
                .addQueryParameter("Country","us")
                .setPriority(Priority.LOW)
                .setTag(tag)
                .build()
                .getAsJSONObject(object :JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        if("error".equals(response!!.getString("status"), true)){
                            Log.d(tag,response.getString("message"))
                        }
                        val articlesCount = response.getJSONArray("articles").length()
                        Log.d(tag,"Found $articlesCount articles")
                    }

                    override fun onError(anError: ANError?) {
                        Log.d(tag, anError!!.message)
                    }

                })


        return view
    }

}// Required empty public constructor
