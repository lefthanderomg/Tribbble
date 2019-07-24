package andrey.murzin.tribbble.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import org.koin.android.scope.currentScope

abstract class BaseFragment : Fragment() {

    @get:LayoutRes
    abstract val layoutResource: Int

    final override fun onCreateView(inflater: LayoutInflater,
                                    container: ViewGroup?,
                                    savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResource, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        currentScope.close()
    }
}