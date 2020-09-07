package cl.desafiolatam.tddpruebasuperheroes.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.tddpruebasuperheroes.R
import cl.desafiolatam.tddpruebasuperheroes.model.remote.pojo.SuperHeroMin
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
        val unkText = "Unknown"
        val noneText = "None"
        val superHero = myDataset[position]
        Picasso.get()
            .load(superHero.img_md)
            .into(holder.photo)
        holder.name_title.text = superHero.name
        when {
            (superHero.appear_race.equals(null)) -> holder.race.text = unkText
            else -> holder.race.text = superHero.appear_race
        }
        when {
            (superHero.appear_height.toString() == ("[-,  0 cm]")) -> holder.height.text = unkText
            else -> holder.height.text = superHero.appear_height.toString()
        }
        when {
            (superHero.appear_weight.toString() == ("[- lb,  0 kg]")) -> holder.weight.text =
                unkText
            else -> holder.weight.text = superHero.appear_weight.toString()
        }
        when {
            (superHero.bio_publisher.equals(null)) -> holder.publisher.text = noneText
            else -> holder.publisher.text = superHero.bio_publisher
        }
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    class SuperHeroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name_title = itemView.superHero_name_item
        var race = itemView.superHero_race_item
        var height = itemView.superHero_height_item
        var weight = itemView.superHero_weight_item
        var publisher = itemView.superHero_publisher_item
        var photo = itemView.superHero_img_list

    }

    fun updateItems(it: List<SuperHeroMin>) {
        myDataset.clear()
        myDataset.addAll(it)
        notifyDataSetChanged()
    }
}