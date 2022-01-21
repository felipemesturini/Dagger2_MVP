package com.example.dagger2lab001.presenter

abstract class BasePresenter<M: Model, V: CustomView<M>>: PresenterIntf<M, V> {
    private var _view: V? = null

    val view: V?
        get() = _view

    override fun bind(view: V) {
        this._view = view
    }

    override fun unbind() {
        this._view = null
    }
}