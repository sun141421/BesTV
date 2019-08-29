/*
 * Copyright (C) 2018 Marcus Pimenta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.pimenta.bestv.feature.splash.di

import android.app.Application
import com.pimenta.bestv.di.module.ApplicationModule
import com.pimenta.bestv.feature.splash.presentation.presenter.SplashPresenter
import com.pimenta.bestv.feature.splash.presentation.ui.fragment.SplashFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by marcus on 2019-08-28.
 */
@Singleton
@Component(
        modules = [
            ApplicationModule::class
        ]
)
interface SplashFragmentComponent {

    fun inject(splashFragment: SplashFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun view(view: SplashPresenter.View): Builder

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): SplashFragmentComponent
    }

    companion object {
        fun build(view: SplashPresenter.View, application: Application): SplashFragmentComponent =
                DaggerSplashFragmentComponent
                        .builder()
                        .view(view)
                        .application(application)
                        .build()
    }
}