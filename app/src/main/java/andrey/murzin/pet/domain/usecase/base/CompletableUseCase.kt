package andrey.murzin.pet.domain.usecase.base

import io.reactivex.Completable

abstract class CompletableUseCase<in PARAMS> {

    fun execute(parameters: PARAMS) = build(parameters)

    protected abstract fun build(parameters: PARAMS): Completable
}