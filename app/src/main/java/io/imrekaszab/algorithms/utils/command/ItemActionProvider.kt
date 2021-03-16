package io.imrekaszab.algorithms.utils.command

typealias ItemAction<T> = (T) -> Unit

interface ItemActionProvider<T> {
    fun setOnItemClickedAction(action: ItemAction<T>?)
}
