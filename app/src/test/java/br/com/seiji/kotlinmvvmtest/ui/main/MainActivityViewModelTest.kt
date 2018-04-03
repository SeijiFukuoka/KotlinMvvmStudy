package br.com.seiji.kotlinmvvmtest.ui.main

import br.com.seiji.kotlinmvvmtest.domain.GitHubRepositoryListResponse
import br.com.seiji.kotlinmvvmtest.data.repository.GitHubRepository
import br.com.seiji.kotlinmvvmtest.util.SchedulerProvider
import br.com.seiji.kotlinmvvmtest.view.MainActivityViewModel
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainActivityViewModelTest {

    @Mock
    private lateinit var mockGitHubRepository: GitHubRepository

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainActivityViewModel = MainActivityViewModel(mockGitHubRepository, schedulerProvider)
    }

    @Test
    fun showDataFromApi() {
        Mockito.`when`(mockGitHubRepository.getDataFromApi()).thenReturn(Single.just(GitHubRepositoryListResponse("20.0.0.0")))

        val testObserver = TestObserver<GitHubRepositoryListResponse>()

        mainActivityViewModel.showDataFromApi()
                .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue { ipAddress -> ipAddress.ip.equals("20.0.0.0") }
    }
}