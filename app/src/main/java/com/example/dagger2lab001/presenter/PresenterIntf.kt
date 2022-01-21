package com.example.dagger2lab001.presenter

interface PresenterIntf<M: Model, V: CustomView<M>> {
    fun bind(view: V)
    fun unbind()
}