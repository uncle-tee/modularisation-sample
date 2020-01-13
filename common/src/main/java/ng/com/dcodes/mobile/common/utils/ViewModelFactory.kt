package ng.com.dcodes.mobile.common.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ng.com.dcodes.mobile.common.utils.di.scopes.Activity
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@Activity
class ViewModelFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            var creator: Provider<out ViewModel>? = creators[modelClass]
            if (creator == null) {
                for ((key, value) in creators) {
                    if (modelClass.isAssignableFrom(key)) {
                        creator = value
                        break
                    }
                }
            }

            requireNotNull(creator) { "unknown model class $modelClass" }

            return try {
                creator.get() as T
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }
    }

