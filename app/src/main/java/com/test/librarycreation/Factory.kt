package com.test.librarycreation

abstract class SingletonProvider<T> {
    abstract fun getData(): T

    @Volatile var instance: T? = null

    companion object {
        inline fun <reified T> create(provider: SingletonProvider<T>): T {
            if (provider.instance == null) {
                synchronized(provider) {
                    if (provider.instance == null) {
                        provider.instance = provider.getData()
                    }
                }
            }

            return provider.instance!!
        }
    }
}

class MyData(val value: Any)

class MyDataProvider : SingletonProvider<MyData>() {
    override fun getData(): MyData {
        return MyData("This is data from MyDataProvider")
    }
}
