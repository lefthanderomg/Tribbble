package andrey.murzin.pet.presentation.base

import andrey.murzin.pet.utils.schedulers.ISchedulersProvider
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseViewModel : ViewModel(), KoinComponent {
    protected val schedulers: ISchedulersProvider by inject()
    protected val disposable: CompositeDisposable by inject()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}