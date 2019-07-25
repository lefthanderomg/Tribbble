package andrey.murzin.pet.presentation.movie.view

import andrey.murzin.pet.R
import andrey.murzin.pet.data.network.IMovieDbApi
import andrey.murzin.pet.presentation.base.BaseFragment
import andrey.murzin.pet.presentation.movie.MovieViewModel
import android.os.Bundle
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : BaseFragment() {

    override val layoutResource: Int = R.layout.fragment_movie

    private val viewModel: MovieViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}