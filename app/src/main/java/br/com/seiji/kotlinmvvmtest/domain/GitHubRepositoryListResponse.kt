package br.com.seiji.kotlinmvvmtest.domain


data class GitHubRepositoryListResponse(
        val total_count: Int,
        val incomplete_results: Boolean,
        val items: List<Repo>
)