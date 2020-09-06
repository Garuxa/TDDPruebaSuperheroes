package cl.desafiolatam.tddpruebasuperheroes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.tddpruebasuperheroes.R
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroMin
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroPojo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.superheroes_list_item.view.*

class SuperHeroAdapter(private var myDataset: MutableList<SuperHeroMin>) :
    RecyclerView.Adapter<SuperHeroAdapter.SuperHeroHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperHeroHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.superheroes_list_item, parent, false)

        return SuperHeroHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroHolder, position: Int) {
        val superHero = myDataset[position]
        Picasso.get()
            .load(superHero.img_md)
            .into(holder.photo)
        holder.name_title.text = superHero.name
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    class SuperHeroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo = itemView.iv_superhero_list
        var name_title = itemView.superhero_name_title
    }

    fun updateItems(it: List<SuperHeroMin>) {
        myDataset.clear()
        myDataset.addAll(it)
        notifyDataSetChanged()
    }
}