package andrey.murzin.pet.presentation.feature.movie.view

import andrey.murzin.pet.R
import andrey.murzin.pet.presentation.base.BaseFragment
import andrey.murzin.pet.presentation.feature.movie.MovieViewModel
import andrey.murzin.pet.presentation.feature.movie.adapter.MovieAdapter
import andrey.murzin.pet.presentation.model.MovieViewEntity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.currentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : BaseFragment() {

    override val layoutResource: Int = R.layout.fragment_movie

    private val viewModel: MovieViewModel by viewModel()
    private val movieAdapter: MovieAdapter by currentScope.inject()
    private val linearLayoutManager: LinearLayoutManager by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(rvMovie) {
            adapter = movieAdapter
            layoutManager = linearLayoutManager
        }

        viewModel.getObservableMovie.observe(
            viewLifecycleOwner,
            Observer<List<MovieViewEntity>> { list: List<MovieViewEntity> ->
                movieAdapter.submitList(list)
            })

        viewModel.getMovie()
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }

}