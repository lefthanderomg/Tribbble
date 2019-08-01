package andrey.murzin.pet.presentation.base

import andrey.murzin.pet.utils.schedulers.ISchedulersProvider
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseViewModel : ViewModel(), KoinComponent {
    protected val schedulers: ISchedulersProvider by inject()
    private val disposable: CompositeDisposable by inject()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    protected fun Disposable.connect() {
        disposable.add(this)
    }
}