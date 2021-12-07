fun main() {
    var executeMe: ExecuteMe = ExecuteMe()
    executeMe.toDelegateFirst()
    executeMe.delegateFirst()
    executeMe.delegateSecond()
    executeMe.toDelegateSecond()
    executeMe.delegateFirst()
    executeMe.delegateSecond()
}

//使用接口的委托模式
interface Delegateinterface {
    fun delegateFirst()
    fun delegateSecond()
}

//被委托类
class DelegateFirst : Delegateinterface {
    override fun delegateFirst() {
        print("yeah! it's ${javaClass.name} delegateFirst()")
    }

    override fun delegateSecond() {
        print("yeah! it's ${javaClass.name} delegateSecond()")
    }

}

//被委托类
class DelegateSecond : Delegateinterface {
    override fun delegateFirst() {
        print("yeah! it's ${javaClass.simpleName} delegateFirst()")
    }

    override fun delegateSecond() {
        print("yeah! it's ${javaClass.name} delegateSecond()")
    }

}

//委托类
class ExecuteMe : Delegateinterface {
    private lateinit var delegateinterface: Delegateinterface
    override fun delegateFirst() {
        delegateinterface.delegateFirst()
    }

    override fun delegateSecond() {
        delegateinterface.delegateSecond()
    }

    fun toDelegateFirst() {
        delegateinterface = DelegateFirst()
    }

    fun toDelegateSecond() {
        delegateinterface = DelegateSecond()
    }
}