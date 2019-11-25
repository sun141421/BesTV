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

package com.pimenta.bestv.feature.castdetail.presentation.ui.activity

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.pimenta.bestv.feature.castdetail.di.CastDetailActivityComponent
import com.pimenta.bestv.feature.castdetail.presentation.processor.CastProcessor
import com.pimenta.bestv.feature.castdetail.presentation.ui.fragment.CastDetailsFragment
import com.pimenta.bestv.presentation.extension.replaceFragment
import javax.inject.Inject

/**
 * Created by marcus on 04-04-2018.
 */
class CastDetailsActivity : FragmentActivity() {

    @Inject
    lateinit var castProcessor: CastProcessor

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CastDetailActivityComponent.build().inject(this)

        when (val castViewModel = castProcessor(intent)) {
            null -> finish()
            else -> replaceFragment(CastDetailsFragment.newInstance(castViewModel))
        }
    }
}