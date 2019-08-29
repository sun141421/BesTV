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

package com.pimenta.bestv.feature.recommendation.di

import android.app.Application
import com.pimenta.bestv.di.module.ApplicationModule
import com.pimenta.bestv.feature.recommendation.presentation.broadcast.BootBroadcastReceiver
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by marcus on 2019-08-29.
 */
@Singleton
@Component(
        modules = [
            ApplicationModule::class
        ]
)
interface BootBroadcastReceiverComponent {

    fun inject(broadcastReceiver: BootBroadcastReceiver)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): BootBroadcastReceiverComponent
    }

    companion object {
        fun build(application: Application): BootBroadcastReceiverComponent =
                DaggerBootBroadcastReceiverComponent
                        .builder()
                        .application(application)
                        .build()
    }
}