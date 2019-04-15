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

package com.pimenta.bestv.common.usecase

import com.pimenta.bestv.common.presentation.mapper.toViewModel
import com.pimenta.bestv.common.presentation.model.VideoViewModel
import com.pimenta.bestv.repository.MediaRepository
import com.pimenta.bestv.repository.entity.Work
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by marcus on 15-04-2019.
 */
class GetVideosUseCase @Inject constructor(
        private val mediaRepository: MediaRepository
) {

    operator fun invoke(work: Work): Single<List<VideoViewModel>?> =
            mediaRepository.getVideosByWork(work)
                    .map { it.videos?.map { video -> video.toViewModel() } }
}