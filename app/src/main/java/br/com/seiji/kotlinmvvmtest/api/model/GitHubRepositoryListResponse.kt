package br.com.seiji.kotlinmvvmtest.api.model


data class GitHubRepositoryListResponse(
        val total_count: Int,
        val incomplete_results: Boolean,
        val items: List<GitHubRepository>
)