package maryam.projects.firstproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class HomeAdapter(
    var ctx : Context? = null ,
    var homeList : ArrayList<HomeData>? = null
) :RecyclerView.Adapter<HomeAdapter.HomeHolder>(){
    class  HomeHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var cityImg = itemView.findViewById<ImageView>(R.id.cityImg)
        var descriptionTxt = itemView.findViewById<TextView>(R.id.descriptionTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        return HomeHolder(
            LayoutInflater.from(ctx).inflate((R.layout.home_items) , parent , false)
        )
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        var currentItem = homeList?.get(position)

        holder.cityImg.setImageResource(currentItem?.Img!!)
        holder.descriptionTxt.text = currentItem.description
    }

    override fun getItemCount(): Int {
        return homeList!!.size
    }
}