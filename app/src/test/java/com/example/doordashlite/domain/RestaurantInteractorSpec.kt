package com.example.doordashlite.domain

import com.example.doordashlite.network.DoorDashAPIRepository
import com.greghaskins.spectrum.Spectrum
import com.greghaskins.spectrum.Spectrum.*
import io.reactivex.Observable
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@RunWith(Spectrum::class)
class RestaurantInteractorSpec {
    private lateinit var interactor: RestaurantInteractor
    @Mock
    private lateinit var mockDoorDashRepository: DoorDashAPIRepository

    init {

        describe("RestaurantInteractor") {
            beforeEach {
                MockitoAnnotations.initMocks(this)
                interactor = RestaurantInteractorImpl(mockDoorDashRepository)
            }

            describe("#getRestuarants") {
                beforeEach {
                    `when`(mockDoorDashRepository.fetchRestaurants(anyString(), anyString(), anyInt(), anyInt())).thenReturn(
                        Observable.just(listOf())
                    )
                }

                it("should fetch restaurants from the repository") {
                    interactor.getRestaurants("0", "0", 0, 0)

                    verify(mockDoorDashRepository, times(1)).fetchRestaurants("0", "0", 0 , 0)
                }

                it("should set default values for offset and limit") {
                    interactor.getRestaurants("0", "0")

                    verify(mockDoorDashRepository, times(1)).fetchRestaurants("0", "0", 0 , 100)
                }
            }

        }
    }
}