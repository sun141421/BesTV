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

package com.pimenta.bestv.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.pimenta.bestv.BesTV;
import com.pimenta.bestv.fragment.SplashFragment;
import com.pimenta.bestv.presenter.DefaultPresenter;

/**
 * Created by marcus on 04-05-2018.
 */
public class SplashActivity extends BaseActivity<DefaultPresenter> {

    public static Intent newInstance(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(SplashFragment.newInstance());
    }

    @Override
    protected void injectPresenter() {
        BesTV.getApplicationComponent().inject(this);
    }
}