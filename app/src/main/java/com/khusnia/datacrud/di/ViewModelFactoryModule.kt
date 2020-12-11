package com.khusnia.datacrud.di



import androidx.lifecycle.ViewModelProvider
import com.khusnia.datacrud.vmfactory.StudentViewModelFactory


abstract class ViewModelFactoryModule {


    internal abstract fun bindViewModelFactory(vMFactory : StudentViewModelFactory) : ViewModelProvider.Factory
}