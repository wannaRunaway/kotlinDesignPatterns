class SingleInstanceDCL {
}

//单例加载时初始化
private object SingleInstance {
    override fun toString(): String {
        println(super.toString() + " " + javaClass.name + " complete")
        return super.toString()
    }
}

//延迟加载、懒加载
private class SingleInstanceLazy {
    companion object {
        val instanceLazy by lazy(LazyThreadSafetyMode.NONE) {
            SingleInstanceLazy()
        }
    }

    override fun toString(): String {
        println(super.toString() + " " + javaClass.name + " complete")
        return super.toString()
    }
}

//同步锁写法
private class SingleInstanceSynchronized{
    companion object {
        private var singleInstanceSynchronized:SingleInstanceSynchronized?=null
        @Synchronized
        fun get():SingleInstanceSynchronized{
            if (null== singleInstanceSynchronized) singleInstanceSynchronized = SingleInstanceSynchronized()
            return singleInstanceSynchronized as SingleInstanceSynchronized
        }
    }
}

//DCL写法
private class SingleInstanceDCLkt{
    companion object{
        val instanceDCL by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
            SingleInstanceDCL()
        }
    }
}

//静态内部类写法
private class SingleInstanceStatic{
    private object SingleStatic{
        val instanceStatic = SingleInstanceStatic()
    }
    companion object {
        fun getInstance() = SingleStatic.instanceStatic
    }
}

private fun main() {
    SingleInstance.toString()
    SingleInstanceLazy.instanceLazy.toString()
    SingleInstanceSynchronized.get().toString()
}