package andrey.murzin.pet.domain.usecase.base

import io.reactivex.Flowable

abstract class FlowableUseCase<in PARAMS, RESULT> {

    fun execute(parameters: PARAMS) = build(parameters)

    protected abstract fun build(parameters: PARAMS): Flowable<RESULT>
}