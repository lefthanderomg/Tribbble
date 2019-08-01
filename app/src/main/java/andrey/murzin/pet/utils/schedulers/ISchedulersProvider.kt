package andrey.murzin.pet.utils.schedulers

import io.reactivex.Scheduler

interface ISchedulersProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}