package com.shoshin.moviereviews.repositories

import com.shoshin.domain.repositories.IApiKeyRepository
import com.shoshin.moviereviews.BuildConfig

class ApiKeyRepository: IApiKeyRepository {
    override fun getApiKey(): String = BuildConfig.API_KEY
}