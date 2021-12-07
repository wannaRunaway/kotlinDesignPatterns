//静态代理
private interface ISubject{
    fun init()
    fun doAction()
}

//真实对象委托类
class RealSubject: ISubject{
    override fun init() {
        println("${javaClass.name} function init()")
    }

    override fun doAction() {
        println("${javaClass.name} function doAction")
    }
}

//代理类
class ProxySubject(var realSubject: RealSubject) : ISubject{
    override fun init() {
        println("${javaClass.name} function init")
    }

    override fun doAction() {
        println("${javaClass.name} doAction start")
        realSubject.doAction()
        println("${javaClass.name} doAction end")
    }
}

fun main(){
    var proxySubject = ProxySubject(RealSubject())
    proxySubject.init()
    proxySubject.doAction()
}

