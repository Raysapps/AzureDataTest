package com.temp.azuredatatest

class ThreadExceptionalHandler: Thread.UncaughtExceptionHandler {

    override fun uncaughtException(t: Thread, e: Throwable) {

        var msg  = e.message;
        var x = 100;
    }
}