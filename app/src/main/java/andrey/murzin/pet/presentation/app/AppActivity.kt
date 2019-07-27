package andrey.murzin.pet.presentation.app

import andrey.murzin.pet.R
import andrey.murzin.pet.presentation.base.BaseFragment
import andrey.murzin.pet.presentation.base.navigation.BaseNavigator
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf
import ru.terrakok.cicerone.NavigatorHolder
import timber.log.Timber

class AppActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "AppActivity"
    }

    private val navigatorHolder: NavigatorHolder by inject()
    private val appLauncher: AppLauncher by currentScope.inject()
    private val navigator: BaseNavigator = currentScope.get {
        parametersOf(this, supportFragmentManager, R.id.container)
    }

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        if (savedInstanceState == null) {
            Timber.d("$TAG coldStart")
            appLauncher.coldStart()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onDestroy() {
        Timber.d("$TAG onDestroy")
        super.onDestroy()
        currentScope.close()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}