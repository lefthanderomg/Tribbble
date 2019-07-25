package andrey.murzin.pet.presentation.base.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class BaseNavigator(
    activity: AppCompatActivity,
    fragmentManager: FragmentManager,
    idContainer: Int
) : SupportAppNavigator(
    activity,
    fragmentManager,
    idContainer
)