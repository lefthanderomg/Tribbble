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
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.currentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MovieFragment : BaseFragment() {

    override val layoutResource: Int = R.layout.fragment_movie

    private val viewModel: MovieViewModel by viewModel()
    private val linearLayoutManager: LinearLayoutManager by inject()
    private val movieAdapter: MovieAdapter by currentScope.inject {
        parametersOf(Glide.with(this))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initMovieList()
        if (savedInstanceState == null) {
            viewModel.getMovie()
        }
        viewModel.getObservableMovie.observe(
            viewLifecycleOwner,
            Observer<List<MovieViewEntity>> { list: List<MovieViewEntity> ->
                movieAdapter.submitList(list)
            })
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }

    private fun initToolbar() {
        toolbar.apply {
            setTitle(R.string.movie)
        }
    }

    private fun initMovieList() {
        with(rvMovie) {
            layoutManager = linearLayoutManager
            adapter = movieAdapter
        }
    }
}