package andrey.murzin.tribbble.presentation.app

import andrey.murzin.tribbble.R
import andrey.murzin.tribbble.presentation.base.navigation.BaseNavigator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf
import ru.terrakok.cicerone.NavigatorHolder

class AppActivity : AppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by inject()
    private val appLauncher: AppLauncher by currentScope.inject()
    private val navigator: BaseNavigator = currentScope.get {
        parametersOf(this, supportFragmentManager, R.id.container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        if (savedInstanceState == null) {
            appLauncher.coldStart()
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onDestroy() {
        super.onDestroy()
        currentScope.close()
    }

}