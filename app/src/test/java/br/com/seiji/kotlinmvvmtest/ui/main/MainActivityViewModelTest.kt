package br.com.seiji.kotlinmvvmtest.ui.main

import br.com.seiji.kotlinmvvmtest.api.model.MyModel
import br.com.seiji.kotlinmvvmtest.repository.Repository
import br.com.seiji.kotlinmvvmtest.util.SchedulerProvider
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
    private lateinit var mockRepository: Repository

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainActivityViewModel = MainActivityViewModel(mockRepository, schedulerProvider)
    }

    @Test
    fun showDataFromApi() {
        Mockito.`when`(mockRepository.getDataFromApi()).thenReturn(Single.just(MyModel("20.0.0.0")))

        val testObserver = TestObserver<MyModel>()

        mainActivityViewModel.showDataFromApi()
                .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue { ipAddress -> ipAddress.ip.equals("20.0.0.0") }
    }
}