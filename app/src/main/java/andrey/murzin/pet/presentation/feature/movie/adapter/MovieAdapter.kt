package andrey.murzin.pet.presentation.feature.movie.adapter

import andrey.murzin.pet.R
import andrey.murzin.pet.presentation.model.MovieViewEntity
import andrey.murzin.pet.utils.ext.inflate
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class MovieAdapter : ListAdapter<MovieViewEntity, MovieAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(parent.inflate(R.layout.item_movie))

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind()
    }

    class MovieViewHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind() {

        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieViewEntity> =
            object : DiffUtil.ItemCallback<MovieViewEntity>() {
                override fun areContentsTheSame(
                    oldItem: MovieViewEntity,
                    newItem: MovieViewEntity
                ): Boolean = oldItem.id == newItem.id

                override fun areItemsTheSame(
                    oldItem: MovieViewEntity,
                    newItem: MovieViewEntity
                ): Boolean = oldItem == newItem
            }
    }

}


